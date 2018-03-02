INSERT INTO owner(id, email, name, login, hash_password, role, state)
  SELECT 1, 'sidikov.marsel@gmail.com', 'Администратор', 'admin', '$2a$10$CR29hxLcDnapMFQRykDIMemIiZSWidn6DHfomvb3/lV5QWAmRPqa6', 'ADMIN', 'CONFIRMED'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM owner
        WHERE id = 1
    );