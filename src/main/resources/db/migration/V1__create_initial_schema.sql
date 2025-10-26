-- Initial schema creation

-- Create users table
CREATE TABLE users (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email  VARCHAR(150) UNIQUE NOT NULL,
date_birth DATE NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
senha_hash TEXT NOT NULL
);

-- Create wallet table
CREATE TABLE wallet (
id SERIAL PRIMARY KEY,
user_id INT NOT NULL,
name VARCHAR(155) NOT NULL,
wallet_value NUMERIC(10,2) DEFAULT 0.00,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_user
	FOREIGN KEY(user_id)
	REFERENCES users(id)
	ON DELETE CASCADE
);

-- Create categories table
CREATE TABLE categories (
id SERIAL PRIMARY KEY,
user_id INT NOT NULL,
name VARCHAR(155) NOT NULL,
description VARCHAR(255),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

CONSTRAINT fk_user
	FOREIGN KEY (user_id)
	REFERENCES users(id)
	ON DELETE CASCADE
);

-- Create transactions table
CREATE TABLE transactions (
id SERIAL PRIMARY KEY,
wallet_id INT NOT NULL,
amount NUMERIC(10,2) NOT NULL CHECK (amount > 0),
date_transaction TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
description VARCHAR(255) NOT NULL,
category VARCHAR(155) NOT NULL,
transaction_type VARCHAR(20) NOT NULL
	CHECK (transaction_type IN ('receita', 'despesa')),

CONSTRAINT fk_wallet
	FOREIGN KEY(wallet_id)
	REFERENCES wallet(id)
	ON DELETE CASCADE
)

-- Create special_categories table
CREATE TABLE special_categories (
id SERIAL PRIMARY KEY,
user_id INT NOT NULL,
name VARCHAR(155) NOT NULL,
limit_value NUMERIC(10,2) NOT NULL,
current_value NUMERIC(10,2) DEFAULT 0.00,
type VARCHAR(20) NOT NULL
	CHECK (type IN ('meta', 'limit')),

CONSTRAINT fk_user
	FOREIGN KEY (user_id)
	REFERENCES users(id)
	ON DELETE CASCADE,

CONSTRAINT unique_user_special UNIQUE (user_id, name)
);
