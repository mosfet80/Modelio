#!/usr/bin/env bash
# Run the Github Copilot CLI in a bubblewrap sandbox. 
# This is intended to be used as a wrapper around the `copilot` command, allowing it to run in a more secure and isolated environment.
#
# Source : https://blog.gpkb.org/posts/ai-agent-sandbox/

set -euo pipefail

# Load Modelio toolkit env
source ../../../../../toolkit/env_toolkit.sh

# Some variables:
#
# ECLIPSETOOL_BIN=${TKPATH}/toolkit/eclipsetool4.35/eclipse
# ECLIPSETOOL_CACHE=${TKPATH}/.cache/eclipsetool4.35
# ECLIPSETOOL_CONFIG_CUSTOM=${TKPATH}/config/eclipse/eclipse-workspace-config.ini
# ECLIPSETOOL_PATH=${TKPATH}/toolkit/eclipsetool4.35
# ECLIPSE_WS=${TKPATH}/work/eclipse
# TKPATH=/work/modelio/alouette

# JAVA_HOME=${TKPATH}/toolkit/jdk21
# JDK17=${TKPATH}/toolkit/jdk17
# JDK21=${TKPATH}/toolkit/jdk21

#PATH=${TKPATH}/toolkit/maven/bin:
#  ${TKPATH}/toolkit/jdk21/bin:
#  ${TKPATH}/toolkit/scripts:.:
#  ${TKPATH}/toolkit/maven/bin:
#  ${TKPATH}/toolkit/jdk21/bin:
#  ${TKPATH}/toolkit/scripts:.:

SANDBOX_PATH=${TKPATH}/toolkit/maven/bin:${TKPATH}/toolkit/jdk21/bin:${TKPATH}/toolkit/maven/bin:${TKPATH}/toolkit/scripts


# capture the current working directory

#Writable directories
W1="${ECLIPSE_WS}/modelio/platform/platform.search.engine"
W2="${ECLIPSE_WS}/modelio/platform/platform.search.engine.test"

# Working directories to keep visible read-only
WR1="${ECLIPSE_WS}/modelio/core/core.kernel"
WR2="${ECLIPSE_WS}/modelio/core/core.session"
WR3="${ECLIPSE_WS}/modelio/core/core.utils"
WR4="${ECLIPSE_WS}/modelio/core/core.project"
WR5="${ECLIPSE_WS}/modelio/core/core.metamodel.api"
WR6="${ECLIPSE_WS}/modelio/app/app.diagram.elements"
WR7="${ECLIPSE_WS}/modelio/app/app.model.search.ui"
WR8="${ECLIPSE_WS}/dev-platform"
WR9="${TKPATH}/work/other/modelio-query-language"

WORKDIR="${ECLIPSE_WS}/modelio/platform/"

COPILOT_DIRS="--add-dir ${W2} --add-dir ${WR1} --add-dir ${WR2} --add-dir ${WR3} --add-dir ${WR4} --add-dir ${WR5} --add-dir ${WR6} --add-dir ${WR7} --add-dir ${WR8} --add-dir ${WR9}"

COPILOT_OPTIONS=--allow-all-tools

mkdir -p $HOME/copilot-home
export COPILOT_CUSTOM_INSTRUCTIONS_DIRS="${W1},${W2},${WR1},${WR2},${WR3},${WR4},${WR5},${WR6},${WR7},${WR8},${WR9}"

#       --unshare-all \
#      --dir /run/user/$(id -u) \
#      --unsetenv  \
#      --setenv XDG_RUNTIME_DIR "/run/user/`id -u`" \
#      --unsetenv USERNAME \
#      --setenv PS1 "bwrap " \

#      --ro-bind "$HOME/.config/dconf" "/copilot/.config/dconf" \
#      --ro-bind "$HOME/.local/share/keyrings" "/copilot/.local/share/keyrings" \

bwrap --ro-bind /usr /usr \
      --dir /tmp \
      --dir /var \
      --symlink ../tmp var/tmp \
      --proc /proc \
      --dev /dev \
      --ro-bind /etc /etc \
      --symlink usr/lib /lib \
      --symlink usr/lib64 /lib64 \
      --symlink usr/bin /bin \
      --symlink usr/sbin /sbin \
      --tmpfs /run \
      --ro-bind /run/systemd/resolve /run/systemd/resolve \
      --unshare-pid \
      --share-net \
      --die-with-parent \
      --new-session \
      --unsetenv LOGNAME \
      --unsetenv LOGDIR \
      --unsetenv LIBVIRT_DEFAULT_URI\
      --unsetenv MAVEN_AUTH_USER \
      --unsetenv MAVEN_AUTH_PASS \
      --unsetenv MEMORY_PRESSURE_WATCH \
      --unsetenv MEMORY_PRESSURE_WRITE \
      --unsetenv PF_PROJECT_URL \
      --unsetenv PROMPT_COMMAND \
      --unsetenv RESOURCES_ECLIPSE_ROOT_URL \
      --unsetenv RUBYOPT \
      --unsetenv SAAS_REALM \
      --unsetenv SAAS_SERVER \
      --unsetenv SAAS_SERVER_URL \
      --unsetenv SAAS_SERVER_USER \
      --unsetenv SAAS_SERVER_USER_TOKEN \
      --unsetenv SSH_AUTH_SOCK\
      --setenv HOME /copilot \
      --setenv PATH "/copilot/bin:/copilot/.local/bin:${SANDBOX_PATH}:$PATH" \
      --setenv COPILOT_CUSTOM_INSTRUCTIONS_DIRS "$COPILOT_CUSTOM_INSTRUCTIONS_DIRS" \
      --bind "$HOME/copilot-home" /copilot \
      --bind "$HOME/.copilot" /copilot/.copilot \
      --ro-bind "$HOME/.gitconfig" "/copilot/.gitconfig" \
      --ro-bind "$HOME/.local/bin" "/copilot/bin" \
      --ro-bind "$HOME/.config/github-copilot" "/copilot/.config/github-copilot" \
      --bind $W1 $W1 \
      --bind $W2 $W2 \
      --ro-bind $WR1 $WR1 \
      --ro-bind $WR2 $WR2 \
      --ro-bind $WR3 $WR3 \
      --ro-bind $WR4 $WR4 \
      --ro-bind $WR5 $WR5 \
      --ro-bind $WR6 $WR6 \
      --ro-bind $WR7 $WR7 \
      --ro-bind $WR8 $WR8 \
      --ro-bind $WR9 $WR9 \
      --ro-bind "${TKPATH}/toolkit" "${TKPATH}/toolkit" \
      --chdir $WORKDIR \
      copilot ${COPILOT_DIRS} ${COPILOT_OPTIONS} $@
