-- THE MEMORY: where our app stores data.
-- Paste this whole file into the browser-based SQL tool & click Run.

-- Table 1: users
CREATE TABLE users (
    user_id INT PRIMARY KEY,        -- primary key: a unique ID for each row
    name    VARCHAR(50) NOT NULL
);

-- Table 2: tasks
CREATE TABLE tasks (
    task_id INT PRIMARY KEY,
    title   VARCHAR(100) NOT NULL,
    done    BOOLEAN NOT NULL,
    user_id INT,                    -- foreign key: points to a row in users
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Sample data
INSERT INTO users (user_id, name) VALUES (1, 'Ada');
INSERT INTO users (user_id, name) VALUES (2, 'Grace');
INSERT INTO users (user_id, name) VALUES (3, 'Katherine');

INSERT INTO tasks (task_id, title, done, user_id) VALUES (1, 'Set up GitHub repo', TRUE,  1);
INSERT INTO tasks (task_id, title, done, user_id) VALUES (2, 'Write login page', FALSE, 1);
INSERT INTO tasks (task_id, title, done, user_id) VALUES (3, 'Design database', TRUE,  2);
INSERT INTO tasks (task_id, title, done, user_id) VALUES (4, 'Write JUnit tests', FALSE, 2);
INSERT INTO tasks (task_id, title, done, user_id) VALUES (5, 'Plan sprint demo', FALSE, 3);
