DROP TABLE MUSIC;

SET DEFINE OFF;

CREATE TABLE MUSIC (
    MUSIC_NO NUMBER NOT NULL,
    TITLE VARCHAR2(100) NOT NULL,
    ARTIST VARCHAR2(100) NOT NULL,
    GENRE VARCHAR2(50) NOT NULL
);

SELECT * FROM MUSIC;

INSERT INTO MUSIC VALUES(1, 'Supernatural', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(2, 'Hot Sweet', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(3, 'Sticky', 'KISS OF LIFE', 'K-pop');
INSERT INTO MUSIC VALUES(4, 'Supernova', 'aespa', 'K-pop');
INSERT INTO MUSIC VALUES(5, 'Small girl (feat. D.O.)', '이영지', 'K-pop');
INSERT INTO MUSIC VALUES(6, 'Armageddon', 'aespa', 'K-pop');
INSERT INTO MUSIC VALUES(7, 'Bubble Gum', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(8, 'Boom Boom Bass', 'RIIZE', 'K-pop');
INSERT INTO MUSIC VALUES(9, '삐그덕', 'NCT 127', 'K-pop');
INSERT INTO MUSIC VALUES(10, 'Right Now', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(11, '踊り子', 'Vaundy', 'J-pop');
INSERT INTO MUSIC VALUES(12, 'Magnetic', '아일릿', 'K-pop');
INSERT INTO MUSIC VALUES(13, '?い珊瑚礁', '마츠다 세이코', 'J-pop');
INSERT INTO MUSIC VALUES(14, '클락션', '(여자)아이들', 'K-pop');
INSERT INTO MUSIC VALUES(15, 'Welcome to the Show', '데이식스', 'K-pop');
INSERT INTO MUSIC VALUES(16, '내가 S면 넌 나의 N이 되어줘', '투어스', 'K-pop');
INSERT INTO MUSIC VALUES(17, '소나기', '이클립스', '발라드');
INSERT INTO MUSIC VALUES(18, 'Attention', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(19, 'Hype Boy', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(20, '고민중독', 'QWER', 'K-pop');
INSERT INTO MUSIC VALUES(21, 'Cosmic', '레드벨벳', 'K-pop');
INSERT INTO MUSIC VALUES(22, 'ETA', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(23, '예뻤어', '데이식스', 'K-pop');
INSERT INTO MUSIC VALUES(24, '한 페이지가 될 수 있게', '데이식스', 'K-pop');
INSERT INTO MUSIC VALUES(25, 'Cruel Summer', 'Taylor Swift', 'Pop');
INSERT INTO MUSIC VALUES(26, 'MILLION DOLLAR BABY', 'Tommy Richman', 'Pop');
INSERT INTO MUSIC VALUES(27, 'Girls Never Die', '트리플에스', 'K-pop');
INSERT INTO MUSIC VALUES(28, 'OMG(Apple Music Edition)', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(29, 'Ditto', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(30, '해야', '아이브', 'K-pop');
INSERT INTO MUSIC VALUES(31, 'Drama', 'aespa', 'K-pop');
INSERT INTO MUSIC VALUES(32, 'Midas Touch', 'KISS OF LIFE', 'K-pop');
INSERT INTO MUSIC VALUES(33, 'Live My Life', 'aespa', 'K-pop');
INSERT INTO MUSIC VALUES(34, 'FOREVER', 'BABYMONSTER', 'K-pop');
INSERT INTO MUSIC VALUES(35, 'TOMBOY', '혁오', 'Rock');
INSERT INTO MUSIC VALUES(36, '첫 만남은 계획대로 되지 않아', '투어스', 'K-pop');
INSERT INTO MUSIC VALUES(37, 'SPOT! (feat. JENNIE)', 'ZICO', 'K-pop');
INSERT INTO MUSIC VALUES(38, 'SHEESH', 'BABYMONSTER', 'K-pop');
INSERT INTO MUSIC VALUES(39, 'Super Shy', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(40, '미안해 미워해 사랑해', '크러쉬', '발라드');
INSERT INTO MUSIC VALUES(41, 'XO (Only If You Say Yes)', '엔하이픈', 'K-pop');
INSERT INTO MUSIC VALUES(42, '사랑한다는 말의 뜻을 알아가자', 'NCT 127', 'K-pop');
INSERT INTO MUSIC VALUES(43, 'Congratulations', '데이식스', 'K-pop');
INSERT INTO MUSIC VALUES(44, 'Who', '지민', 'K-pop');
INSERT INTO MUSIC VALUES(45, 'Chk Chk Boom', 'Stray Kids', 'K-pop');
INSERT INTO MUSIC VALUES(46, 'Espresso', 'Sabrina Carpenter', 'Pop');
INSERT INTO MUSIC VALUES(47, 'Impossible', 'RIIZE', 'K-pop');
INSERT INTO MUSIC VALUES(48, 'Earth, Wind & Fire', '보이넥스트도어', 'K-pop');
INSERT INTO MUSIC VALUES(49, 'Cool With You', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(50, '그대만 있다면 (영화 '여름날 우리')', 'Nerd Connection', 'K-pop');
INSERT INTO MUSIC VALUES(51, 'ABCD', 'NAYEON', 'K-pop');
INSERT INTO MUSIC VALUES(52, 'New Jeans', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(53, 'Sugarcoat (NATTY Solo)', 'KISS OF LIFE', 'K-pop');
INSERT INTO MUSIC VALUES(54, 'Lucky Girl Syndrome', '아일릿', 'K-pop');
INSERT INTO MUSIC VALUES(55, 'Siren', 'RIIZE', 'K-pop');
INSERT INTO MUSIC VALUES(56, '나는 아픈 건 딱 질색이니까', '(여자)아이들', 'K-pop');
INSERT INTO MUSIC VALUES(57, 'Love wins all', '아이유', 'K-pop');
INSERT INTO MUSIC VALUES(58, 'Cookie', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(59, 'Hurt', '뉴진스', 'K-pop');
INSERT INTO MUSIC VALUES(60, '에피소드', '이무진', 'K-pop');
INSERT INTO MUSIC VALUES(61, '좋은 밤 좋은 꿈', 'Nerd Connection', '락발라드');
INSERT INTO MUSIC VALUES(62, 'Love 119', 'RIIZE', 'K-pop');
INSERT INTO MUSIC VALUES(63, 'Vancouver', 'BIG Naughty', 'Hip-hop');
INSERT INTO MUSIC VALUES(64, '주저하는 연인들을 위해', '잔나비', '발라드');
INSERT INTO MUSIC VALUES(65, 'I AM', '아이브', 'K-pop');
INSERT INTO MUSIC VALUES(66, '천상연', '이창섭', '발라드');
INSERT INTO MUSIC VALUES(67, 'EVERYTHING', '검정치마', '모던 락');
INSERT INTO MUSIC VALUES(68, 'Trip (feat. Hannah)', '릴러말즈', 'Hip-hop');
INSERT INTO MUSIC VALUES(69, 'Yours', '데이먼스 이어', '발라드');
INSERT INTO MUSIC VALUES(70, '봄눈', '10cm', '발라드');
INSERT INTO MUSIC VALUES(71, 'Bye Bye My Blue', '백예린', 'R&B');
INSERT INTO MUSIC VALUES(72, 'Love me or Leave me', '데이식스', 'K-pop');
INSERT INTO MUSIC VALUES(73, '거리에서', '성시경', '발라드');
INSERT INTO MUSIC VALUES(74, '인사', '범진', '발라드');
INSERT INTO MUSIC VALUES(75, 'Accendio', '아이브', 'K-pop');
INSERT INTO MUSIC VALUES(76, 'Antifreeze', '백예린', '발라드');
INSERT INTO MUSIC VALUES(77, 'Next Level', 'aespa', 'K-pop');
INSERT INTO MUSIC VALUES(78, 'Seven (Explicit Ver.)', '정국 & Latto', 'K-pop');
INSERT INTO MUSIC VALUES(79, 'ベテルギウス', 'Yuuri', 'J-pop');
INSERT INTO MUSIC VALUES(80, 'Songbird (Korean Version)', 'NCT WISH', 'K-pop');
INSERT INTO MUSIC VALUES(81, 'Young Man', '혁오 & Sunset Rollercoaster', 'Rock');
INSERT INTO MUSIC VALUES(82, 'Spicy', 'aespa', 'K-pop');
INSERT INTO MUSIC VALUES(83, 'Not Like Us', 'Kendrick Lamar', 'Hip-hop');
INSERT INTO MUSIC VALUES(84, 'Talk Saxy', 'RIIZE', 'K-pop');
INSERT INTO MUSIC VALUES(85, 'BIRDS OF A FEATHER', 'Billie Eilish', 'Pop');
INSERT INTO MUSIC VALUES(86, '숲', '최유리', '인디');
INSERT INTO MUSIC VALUES(87, '어떻게 이별까지 사랑하겠어, 널 사랑하는 거지', '악뮤', '발라드');
INSERT INTO MUSIC VALUES(88, 'LOVE DIVE', '아이브', 'K-pop');
INSERT INTO MUSIC VALUES(89, 'OST (feat. Chanmina)', 'ASH ISLAND', 'Rock');
INSERT INTO MUSIC VALUES(90, 'Balloon in Love', '선미', 'K-pop');
INSERT INTO MUSIC VALUES(91, 'Please Please Please', 'Sabrina Carpenter', 'Pop');
INSERT INTO MUSIC VALUES(92, 'Be Mine', '지민', 'K-pop');
INSERT INTO MUSIC VALUES(93, 'Pricey', 'NCT 127', 'K-pop');
INSERT INTO MUSIC VALUES(94, '네가 내 마음에 자리 잡았다', '엔플라잉', 'Rock');
INSERT INTO MUSIC VALUES(95, 'Blue Moon', '엔플라잉', 'Rock');
INSERT INTO MUSIC VALUES(96, 'Smeraldo Garden Marching Band (feat. Loco)', '지민', 'K-pop');
INSERT INTO MUSIC VALUES(97, 'Heaven', '태연', 'K-pop');
INSERT INTO MUSIC VALUES(98, '오렌지색 물감', 'NCT 127', 'K-pop');
INSERT INTO MUSIC VALUES(99, 'Memories', 'RIIZE', 'K-pop');
INSERT INTO MUSIC VALUES(100, '도깨비불', 'aespa', 'K-pop');

COMMIT;