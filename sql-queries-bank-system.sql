--CREATE TABLE Account(
--	AccountID INT IDENTITY(1,1),
--	BankCode NUMERIC(18,0) NOT NULL, 
--	Username VARCHAR(30) NOT NULL, 
--	Password VARCHAR(50) NOT NULL,
--	Funds NUMERIC(13, 4) NOT NULL,

--	CONSTRAINT PK_Account PRIMARY KEY (AccountID),
--	CONSTRAINT UQ_Account_BankCode UNIQUE (BankCode),
--	CONSTRAINT UQ_Account_Username UNIQUE (Username)
--)

--CREATE TABLE DebitCard (
--	DebitCardID INT IDENTITY(1,1),
--	Number NUMERIC(16,0) NOT NULL,
--	NIP NUMERIC(4,0) NOT NULL,
--	Funds NUMERIC(13,4) NOT NULL,
--	IsDefault BIT NOT NULL,
--	AccountID INT,

--	CONSTRAINT PK_CreditCard PRIMARY KEY (DebitCardID), 
--	CONSTRAINT UQ_CreditCard_Number UNIQUE (Number),
--	CONSTRAINT FK_CreditCard_Owner FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
--)

--CREATE TABLE TransactionToAcccount (
--	TransactionID INT IDENTITY(1,1),
--	OriginAccountID INT, 
--	ReceiverAccountID INT,
--	Amount NUMERIC(13,4) NOT NULL,
--	TransactionDate DATETIME NOT NULL,

--	CONSTRAINT PK_TransactionID PRIMARY KEY (TransactionID),
--	CONSTRAINT FK_Transaction_OriginAccount FOREIGN KEY (OriginAccountID)
--		REFERENCES Account(AccountID),
--	CONSTRAINT FK_Transaction_ReceiverAccount FOREIGN KEY (ReceiverAccountID)
--		REFERENCES Account(AccountID),
	
--)

--CREATE TABLE TransactionToDebitCard (
--	TransactionID INT IDENTITY(1,1),
--	OriginDebitCardID INT,
--	ReceiverDebitCardID INT,
--	Amount NUMERIC(13,4) NOT NULL,
--	TransactionDate DATETIME NOT NULL,

--	CONSTRAINT FK_Transaction_OriginDebitCard FOREIGN KEY (OriginDebitCardID)
--		REFERENCES DebitCard(DebitCardID),
--	CONSTRAINT FK_Transaction_ReceiverDebitCard FOREIGN KEY (ReceiverDebitCardID)
--		REFERENCES DebitCard(DebitCardID)
--)