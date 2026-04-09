INSERT INTO words (english, japanese)
SELECT 'apple', 'りんご'
WHERE NOT EXISTS (SELECT 1 FROM words WHERE english = 'apple');

INSERT INTO words (english, japanese)
SELECT 'banana', 'バナナ'
WHERE NOT EXISTS (SELECT 1 FROM words WHERE english = 'banana');

INSERT INTO words (english, japanese)
SELECT 'cat', 'ねこ'
WHERE NOT EXISTS (SELECT 1 FROM words WHERE english = 'cat');

INSERT INTO words (english, japanese)
SELECT 'dog', 'いぬ'
WHERE NOT EXISTS (SELECT 1 FROM words WHERE english = 'dog');

INSERT INTO words (english, japanese)
SELECT 'book', 'ほん'
WHERE NOT EXISTS (SELECT 1 FROM words WHERE english = 'book');
