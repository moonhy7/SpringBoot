CREATE TABLE MEMBER (
	ID VARCHAR(10) PRIMARY KEY,
    PASSWORD VARCHAR(100),
    NAME VARCHAR(30),
    ROLE VARCHAR(12),
    ENABLED VARCHAR(1)
);

SELECT * FROM MEMBER;

INSERT INTO MEMBER (ID, PASSWORD, NAME, ROLE, ENABLED) VALUES ('member', 'member123', '회원', 'ROLE_MEMBER', 'Y');
INSERT INTO MEMBER (ID, PASSWORD, NAME, ROLE, ENABLED) VALUES ('manager', 'manager123', '매니저', 'ROLE_MANAGER', 'Y');
INSERT INTO MEMBER (ID, PASSWORD, NAME, ROLE, ENABLED) VALUES ('admin', 'admin123', '어드민', 'ROLE_ADMIN', 'Y');