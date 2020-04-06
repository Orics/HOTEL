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

EXEC pro_InsertEmployee 
	@roleid = 1, 
	@password = '123456', 
	@empname = N'Nguyễn Văn A', 
	@birthday = '01/01/1990', 
	@gender = 'Male', 
	@phone = '0987654321', 
	@email = 'email@gmail.com';

---------------------------------------------------------------------
--17520605------------------------------------------------
----------------------------------------------------------------

CREATE PROCEDURE pro_InsertEmployee
(
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
	@email = 'email@gmail.com'
	--------------------------------------------------------


CREATE PROCEDURE pro_InsertRoom
(
  @RoomMumber nvarchar(50),
  @RoomTypeID int,
  @Status nvarchar(50)
)
AS 
BEGIN
	INSERT INTO Room VALUES (@RoomMumber,@RoomTypeID,@Status);
	SELECT SCOPE_IDENTITY() AS ID;
END;

EXEC pro_InsertRoom
@RoomMumber='1',
@RoomTypeID='12',
@Status='123'

----------------------------------------------
CREATE PROCEDURE pro_InsertRoomType(
  @RoomTypeName nvarchar(50),
  @SingleCount int,
  @CoupleCount int,
  @BasePrice int
)
AS 
BEGIN
	INSERT INTO RoomType VALUES (@RoomTypeName,@SingleCount,@CoupleCount,@BasePrice);
	SELECT SCOPE_IDENTITY() AS ID;
END;

EXEC pro_InsertRoomType
@RoomTypeName='12',
@SingleCount='12',
@CoupleCount='21',
@BasePrice='123'
-----------------------------------------------------
CREATE PROCEDURE pro_InsertRoomChange(
  @OldResDetailID int,
  @NewResDetailID int,
  @Reason nvarchar(500)
)
AS 
BEGIN
	INSERT INTO RoomChange VALUES (@OldResDetailID,@NewResDetailID,@Reason);
	SELECT SCOPE_IDENTITY() AS ID;
END;

EXEC pro_InsertRoomChange

@OldResDetailID='123',
@NewResDetailID='20',
@Reason='125'
-----------------------------------------------------
CREATE PROCEDURE pro_InsertRole(
  @RoleName nvarchar(50)
)
AS 
BEGIN
	INSERT INTO Role VALUES (@RoleName);
	SELECT SCOPE_IDENTITY() AS ID;
END;

EXEC pro_InsertRole
@RoleName='1256'
---------------------------------------------------------
CREATE PROCEDURE pro_InsertReg_Reservation(

  @ApplyTime datetime,
  @HoldingDayRate float,
  @HoldingDay int
)
AS 
BEGIN
	INSERT INTO Reg_Reservation VALUES (@ApplyTime,@HoldingDayRate,@HoldingDay);
	SELECT SCOPE_IDENTITY() AS ID;
END;
EXEC pro_InsertReg_Reservation
@ApplyTime='1/1/2020',
@HoldingDayRate='4525',
@HoldingDay='2536'
------------------------------------------------------------------
SELECT *FROM dbo.Role
SELECT *FROM dbo.RoomChange
SELECT *FROM dbo.Room
SELECT *FROM dbo.Employee
SELECT *FROM dbo.Reg_Reservation