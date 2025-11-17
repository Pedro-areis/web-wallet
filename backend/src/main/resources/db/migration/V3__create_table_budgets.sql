-- Create table budgets
CREATE TABLE budgets (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
amount NUMERIC(10, 2) NOT NULL CHECK (amount > 0),
current_value NUMERIC(10,2) DEFAULT 0.00,
status VARCHAR(20) NOT NULL
    CHECK (status IN ('pendente', 'pago', 'vencido')),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

user_id INT NOT NULL,
category_id INT NOT NULL,

CONSTRAINT fk_user
    FOREIGN KEY(user_id)
    REFERENCES users(id)
    ON DELETE CASCADE,

CONSTRAINT fk_category
    FOREIGN KEY(category_id)
    REFERENCES categories(id)
    ON DELETE CASCADE,

CONSTRAINT unique_budgets_user UNIQUE (user_id, name)
);