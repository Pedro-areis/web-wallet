-- Atualiza a tabela "users", adicionando a coluna "profile_image_url" e "note"
-- Atualiza a tabela "special_categories", adicionando a coluna "description" e "created_at"

ALTER TABLE users
ADD COLUMN profile_image_url TEXT,
ADD COLUMN note TEXT;

ALTER TABLE special_categories
ADD COLUMN description VARCHAR(255),
ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;