-- SQL PRACTICE: run these one at a time AFTER running schema.sql.
-- CRUD = Create, Read, Update, Delete

-- C (Create) -> INSERT: add a task for Katherine
INSERT INTO tasks (task_id, title, done, user_id) VALUES (6, 'Review a pull request', FALSE, 3);

-- R (Read) -> SELECT: see every task
SELECT * FROM tasks;

-- R (Read) with a filter: see only tasks that are not done
SELECT title FROM tasks WHERE done = FALSE;

-- U (Update) -> UPDATE: mark task 2 as done
UPDATE tasks SET done = TRUE WHERE task_id = 2;

-- D (Delete) -> DELETE: remove task 5
DELETE FROM tasks WHERE task_id = 5;

-- R (Read) -> SELECT: see every task to confirm your changes
SELECT * FROM tasks;

-- CHALLENGE: show the titles of all of Grace's tasks.
-- Use the pattern:  SELECT column FROM table WHERE condition;
--   Step 1: find Grace's user_id in the users table.
--   Step 2: use that user_id to find her tasks in the tasks table.
-- Try it yourself before looking at the answer below!

























-- ANSWER:
-- Step 1: SELECT user_id FROM users WHERE name = 'Grace';
--         (result: 2)
-- Step 2: SELECT title FROM tasks WHERE user_id = 2;
