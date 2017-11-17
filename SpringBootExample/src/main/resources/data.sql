INSERT INTO owner(id, email, name, login, hash_password, role)
  SELECT 1, 'sidikov.marsel@gmail.com', 'Администратор', 'admin', '$2a$10$3NH7OGRDOyg767yZoMcAZO4tAbueH7kSIt2WmgPX0ZEUbEFahVftG', 'ADMIN'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM owner
        WHERE id = 1
    );