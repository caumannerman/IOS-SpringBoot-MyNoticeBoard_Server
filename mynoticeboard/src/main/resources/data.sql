INSERT INTO post(id, title, content, time, user_nickname, hashtag) VALUES ( 1, 'title1입니다', '내용입니다1111', '13:31', 'nickname1','#hahaha1 #hohoho #kkk');
INSERT INTO post(id, title, content, time, user_nickname, hashtag) VALUES ( 2, 'title2입니다', '내용입니다12222', '13:29', 'nickname2','#hahaha2 #hohoho #kkk');
INSERT INTO post(id, title, content, time, user_nickname, hashtag) VALUES ( 3, 'title3입니다', '내용입니다3333', '13:56', 'nickname3','#hahaha3 #hohoho #kkk');
INSERT INTO post(id, title, content, time, user_nickname, hashtag) values ( 4, 'title4입니다', '내용입니다4444', '12:17', 'nickname4','#hahaha4 #hohoho #kkk');
INSERT INTO post(id, title, content, time, user_nickname, hashtag) values ( 5, 'title5입니다', '내용입니다5555', '16:42', 'nickname5','#hahaha5 #hohoho #kkk');
INSERT INTO post(id, title, content, time, user_nickname, hashtag) values ( 6, 'title6입니다', '내용입니다6666', '18:22', 'nickname6','#hahaha6 #hohoho #kkk');
INSERT INTO post(id, title, content, time, user_nickname, hashtag) values ( 7, 'title7입니다', '내용입니다7777', '21:08', 'nickname7','#hahaha7 #hohoho #kkk');


--comment 더미 데이터
INSERT INTO comment(id, post, nickname, content, time) values (1, 1, '양준식', '1등', '20:16');
INSERT INTO comment(id, post, nickname, content, time) values (2, 1, '박중필', '2등~', '20:16');
INSERT INTO comment(id, post, nickname, content, time) values (3, 1, '이승준', '3등이요', '20:16');

INSERT INTO comment(id, post, nickname, content, time) values (4, 3, '양준식', '1등이네', '20:16');
INSERT INTO comment(id, post, nickname, content, time) values (5, 3, '이승준', '하하', '20:16');
INSERT INTO comment(id, post, nickname, content, time) values (6, 3, '박중필', '호호', '20:16');

INSERT INTO comment(id, post, nickname, content, time) values (7, 5, '진성민', '운동 ㄱ', '20:16');
INSERT INTO comment(id, post, nickname, content, time) values (8, 5, '박승수', '운동 안 해', '20:16');
INSERT INTO comment(id, post, nickname, content, time) values (9, 5, '이승준', '운동 좀 해라', '20:16');