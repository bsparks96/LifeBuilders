DROP SCHEMA IF EXISTS `LifeBuilders` ;
CREATE DATABASE LifeBuilders;
USE LifeBuilders;

-- DDL Script for Life Builders Database

-- ========================
-- TABLE: Users
-- ========================
CREATE TABLE Users (
    userID INT PRIMARY KEY,  -- Starts at 11111
    username VARCHAR(100) NOT NULL UNIQUE,
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    userRole VARCHAR(50)
);

-- ========================
-- TABLE: Clients
-- ========================
CREATE TABLE Clients (
    clientID INT PRIMARY KEY,  -- Starts at 20000
    clientFirstName VARCHAR(100),
    clientLastName VARCHAR(100),
    clientEmail VARCHAR(255),
    clientDOB DATE,
    clientSSN CHAR(9),  -- Consider encryption for real deployment
    clientGender VARCHAR(50)
);

-- ========================
-- TABLE: ClientHasPreAssessments
-- ========================
CREATE TABLE clientHasPreAssessments (
    preAssessmentID INT PRIMARY KEY AUTO_INCREMENT,
    clientID INT,
    assessmentCompletionDate DATE,
    FOREIGN KEY (clientID) REFERENCES Clients(clientID)
);

-- ========================
-- TABLE: ClientHasPostAssessments
-- ========================
CREATE TABLE ClientHasPostAssessments (
    postAssessmentID INT PRIMARY KEY AUTO_INCREMENT,
    clientID INT,
    assessmentCompletionDate DATE,
    FOREIGN KEY (clientID) REFERENCES Clients(clientID)
);

-- ========================
-- TABLE: Courses
-- ========================
CREATE TABLE Courses (
    courseID INT PRIMARY KEY,
    courseName VARCHAR(200),
    courseDescription TEXT,
    courseLength INT  -- in days or hours
);

-- ========================
-- TABLE: CourseIterations
-- ========================
CREATE TABLE CourseIterations (
    iterationID INT PRIMARY KEY,
    courseID INT,
    courseInstructorID INT,
    courseStartDate DATE,
    courseEndDate DATE,
    FOREIGN KEY (courseID) REFERENCES Courses(courseID),
    FOREIGN KEY (courseInstructorID) REFERENCES Users(userID)
);

-- ========================
-- TABLE: CourseHasClients
-- ========================
CREATE TABLE CourseHasClients (
    iterationID INT,
    clientID INT,
    completionDate DATE,
    PRIMARY KEY (iterationID, clientID),
    FOREIGN KEY (iterationID) REFERENCES CourseIterations(iterationID),
    FOREIGN KEY (clientID) REFERENCES Clients(clientID)
);

-- ========================
-- TABLE: CommunityEvents
-- ========================
CREATE TABLE CommunityEvents (
    commEventID INT PRIMARY KEY,
    eventName VARCHAR(255),
    commStartDate DATE,
    commEndDate DATE,
    commLocation VARCHAR(255),
    commEventSize INT
);

-- ========================
-- TABLE: CommunityEventLeaders
-- ========================
CREATE TABLE CommunityEventLeaders (
    commEventID INT,
    userID INT,
    PRIMARY KEY (commEventID, userID),
    FOREIGN KEY (commEventID) REFERENCES CommunityEvents(commEventID),
    FOREIGN KEY (userID) REFERENCES Users(userID)
);
