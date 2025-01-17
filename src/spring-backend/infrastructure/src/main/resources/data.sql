-- Insert 10 dummy records into `users`
INSERT INTO users (user_name) VALUES
('Alice'),
('Bob'),
('Charlie'),
('Diana'),
('Eve'),
('Frank'),
('Grace'),
('Hank'),
('Ivy'),
('Jack');

-- Insert 10 dummy records into `diaries`
INSERT INTO diaries (user_id, title, content, updated_date) VALUES
(1, 'Morning Walk', 'Enjoyed a refreshing morning walk in the park.', '2025-01-10 07:00:00'),
(1, 'Project Update', 'Completed phase 1 of the project successfully.', '2025-01-10 15:30:00'),
(2, 'Shopping List', 'Bought apples, bananas, and oranges today.', '2025-01-11 10:00:00'),
(2, 'Lunch Review', 'Had a delicious pasta meal at the new cafe.', '2025-01-11 13:00:00'),
(3, 'Workout Plan', 'Planning to do strength training three times a week.', '2025-01-12 08:00:00'),
(3, 'Book Notes', 'Read the first three chapters of a fascinating novel.', '2025-01-12 20:00:00'),
(4, 'Travel Journal', 'Visited a beautiful mountain trail this weekend.', '2025-01-13 09:00:00'),
(4, 'Recipe Notes', 'Tried a new recipe for homemade pizza today.', '2025-01-13 18:00:00'),
(5, 'Tech Trends', 'Explored the latest trends in AI and machine learning.', '2025-01-14 14:30:00'),
(5, 'Weekend Plans', 'Planning a hike and picnic for the weekend.', '2025-01-14 20:00:00');
