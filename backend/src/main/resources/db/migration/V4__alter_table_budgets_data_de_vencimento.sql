--ALTER TABLE special_categories
--ADD COLUMN description VARCHAR(255),
--ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- Altera coluna budgets para adicionar Due Date;
ALTER TABLE budgets
ADD COLUMN due_date DATE NOT NULL;