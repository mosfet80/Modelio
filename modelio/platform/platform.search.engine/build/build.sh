#!/bin/bash
set -u

# Build the project with Maven.
#
# Default mode is compact:
# - Full Maven output goes to mvn-build.log
# - Terminal prints only a short summary
#
# Use --verbose to stream full Maven output to terminal.

CURDIR="$(dirname "$0")"
cd "$CURDIR" || exit 1

LOG_FILE="mvn-build.log"
EXIT_FILE="mvn-exit.txt"

rm -f "$LOG_FILE" "$EXIT_FILE"

source /work/modelio/alouette/toolkit/env_toolkit.sh

verbose=0
maven_args=()
for arg in "$@"; do
	if [[ "$arg" == "--verbose" ]]; then
		verbose=1
	else
		maven_args+=("$arg")
	fi
done

maven_cmd=(mvn -q --no-transfer-progress -Dstyle.color=never -DskipTests=true install)

if [[ $verbose -eq 1 ]]; then
	"${maven_cmd[@]}" "${maven_args[@]}" |& tee "$LOG_FILE"
	mvn_exit=${PIPESTATUS[0]}
else
	"${maven_cmd[@]}" "${maven_args[@]}" >"$LOG_FILE" 2>&1
	mvn_exit=$?
fi

echo "$mvn_exit" > "$EXIT_FILE"

echo "Build exit code: $mvn_exit"
echo "Log file: $LOG_FILE"

if [[ $mvn_exit -eq 0 ]]; then
	if grep -q "BUILD SUCCESS" "$LOG_FILE"; then
		echo "Result: BUILD SUCCESS"
	else
		echo "Result: SUCCESS (no explicit BUILD SUCCESS marker found)"
	fi
else
	echo "Result: BUILD FAILURE"
	echo "----- failure summary (filtered) -----"
	grep -E "BUILD FAILURE|\[ERROR\]|Failed to execute goal|There are test failures|COMPILATION ERROR" "$LOG_FILE" | tail -n 40
	echo "----- failure tail -----"
	tail -n 60 "$LOG_FILE"
fi