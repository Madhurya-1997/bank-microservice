DROP TABLE IF EXISTS loans;

CREATE TABLE `loan` (
  `loan_number` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `start_date` date NOT NULL,
  `loan_type` varchar(100) NOT NULL,
  `total_loan` int NOT NULL,
  `amount_paid` int NOT NULL,
  `outstanding_amount` int NOT NULL,
  `creation_date` date DEFAULT NULL,
  PRIMARY KEY (`loan_number`)
);

INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `creation_date`)
 VALUES ( 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2018-10-13');
 
INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `creation_date`)
 VALUES ( 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2018-06-06');
 
INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `creation_date`)
 VALUES ( 1, '2021-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `creation_date`)
 VALUES ( 1, '2020-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');
 
