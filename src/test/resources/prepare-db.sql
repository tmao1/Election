use election;

set FOREIGN_KEY_CHECKS = 0;
truncate table candidates;
truncate table voters;
truncate table voters_candidates;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `Election`.`candidates` (`id`, `position`, `name`, `total_votes`, `party`) VALUES ('1', 'P', 'Hillary', '0', 'D');
INSERT INTO `Election`.`candidates` (`id`, `position`, `name`, `total_votes`, `party`) VALUES ('2', 'P', 'Trump', '0', 'R');

INSERT INTO `Election`.`voters` (`id`, `name`, `gender`, `age`, `race`, `state`, `version`) VALUES ('1', 'Tom', 'M', '30', 'WHITE', 'IL', '1');
INSERT INTO `Election`.`voters` (`id`, `name`, `gender`, `age`, `race`, `state`, `version`) VALUES ('2', 'Sally', 'F', '40', 'BLACK', 'IL', '2');


INSERT INTO `Election`.`voters_candidates` (`voter_id`, `candidate_id`) VALUES ('1', '2');
INSERT INTO `Election`.`voters_candidates` (`voter_id`, `candidate_id`) VALUES ('2', '2');

