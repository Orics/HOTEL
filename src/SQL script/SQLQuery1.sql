CREATE DATABASE hotel;
go
USE hotel;
GO

DROP TABLE dbo.Employee;

CREATE TABLE Employee(
	EmpID INT PRIMARY KEY IDENTITY(10000,1),
	RoleID INT,
	Password NVARCHAR(50),
	EmpName NVARCHAR(50),
	BirthDay DATE,
	Gender NVARCHAR(50),
	Phone NVARCHAR(50),
	Email NVARCHAR(50)
)

CREATE TABLE Role(
	RoleID INT PRIMARY KEY IDENTITY(1,1),
	RoleName NVARCHAR(50)
)


INSERT INTO dbo.Role ( RoleName ) VALUES  ( N'Manager');

INSERT INTO dbo.Employee
VALUES  (1, '123456', N'Nguyễn Văn A', '01/01/1990', 'Male', '0987654321', 'email@gmail.com');

SELECT * FROM dbo.Employee;

DROP PROCEDURE pro_InsertEmployee

CREATE PROCEDURE pro_InsertEmployee(
	@roleid int, 
	@password nvarchar(50), 
	@empname nvarchar(50), 
	@birthday date, 
	@gender nvarchar(50), 
	@phone nvarchar(50), 
	@email nvarchar(50)
)
AS 
BEGIN
	INSERT INTO Employee VALUES (@roleid, @password, @empname, @birthday, @gender, @phone, @email);
	SELECT SCOPE_IDENTITY() AS ID;
END;



EXEC pro_InsertEmployee 
	@roleid = 1, 
	@password = '123456', 
	@empname = N'Nguyễn Văn A', 
	@birthday = '01/01/1990', 
	@gender = 'Male', 
	@phone = '0987654321', 
	@email = 'email@gmail.com';
