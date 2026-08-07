DROP SCHEMA PUBLIC CASCADE;
-- **commit**

SET DATABASE DEFAULT TABLE TYPE CACHED;
SET DATABASE SQL TRUNCATE TRAILING TRUE;

-- Sets logging of database operations on or off. 
-- Turning logging off is for special usage, such as temporary cache usage. The default is TRUE.
SET FILES LOG FALSE;

-- https://hsqldb.org/doc/2.0/guide/guide.html#tspace_usage
SET FILES SPACE TRUE;

SET DATABASE EVENT LOG LEVEL 2;
SET DATABASE EVENT LOG SQL LEVEL 0;

-- TABLE "elements"
CREATE CACHED TABLE "elements" (
	id VARCHAR(50) PRIMARY KEY,
	clsname VARCHAR(255),
	name VARCHAR(1024),
	cmsnodeid VARCHAR(50),
	cmsnodecls VARCHAR(255));
	
-- **commit**
SET TABLE "elements" NEW SPACE ;
CREATE INDEX "idx_elements_cls" ON "elements" (clsname) ;
CREATE INDEX "idx_elements_owner" ON "elements" (cmsnodeid);


CREATE TABLE "cmsnode" (
	id VARCHAR(50) PRIMARY KEY,
	clsname VARCHAR(255),
	parentid VARCHAR(50),
	parentcls VARCHAR(255))

-- **commit**

SET TABLE "cmsnode" NEW SPACE ;
CREATE INDEX "idx_cmsnode_owner" ON "cmsnode" (parentid);

-- TABLE "dependencies"
CREATE TABLE "dependencies" (
	srcid VARCHAR(50) ,
	depname VARCHAR(1024),
	targetid VARCHAR(50),
	)
	
	
-- **commit**
SET TABLE "dependencies" NEW SPACE ;
CREATE INDEX "idx_dependencies_from" ON "dependencies" (srcid, depname);
CREATE INDEX "idx_dependencies_to" ON "dependencies" (targetid, depname);

-- TABLE "metadatas"
CREATE TABLE "metadatas" ("key" VARCHAR(255) PRIMARY KEY, "val" VARCHAR(1024))

