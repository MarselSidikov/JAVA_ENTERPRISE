INSERT INTO owner(id, name, login, hash_password, role)
  SELECT 1, 'Администратор', 'admin', '$2a$10$3NH7OGRDOyg767yZoMcAZO4tAbueH7kSIt2WmgPX0ZEUbEFahVftG', 'ADMIN'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM owner
        WHERE id = 1
    );