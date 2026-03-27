-- 問題1: 重複を除いて全ての部署名を取得
SELECT DISTINCT department
FROM employees;

-- 問題2: 給与の高い順、同じ給与はフリガナ昇順
SELECT name, salary
FROM employees
ORDER BY salary DESC, name_kana ASC;

-- 問題3: 給与55000以上 かつ 雇用日2020年以降の部署をINTERSECTで取得
SELECT department
FROM employees
WHERE salary >= 55000
INTERSECT
SELECT department
FROM employees
WHERE hire_date >= '2020-01-01';

-- 問題4: 部署が「IT」または「開発」以外の社員名をNOT INで取得
SELECT name
FROM employees
WHERE department NOT IN ('IT', '開発');

-- 問題5: 給与50000以上 または 雇用日2020年以降の社員名と部署をUNIONで取得
SELECT name, department
FROM employees
WHERE salary >= 50000
UNION
SELECT name, department
FROM employees
WHERE hire_date >= '2020-01-01';
