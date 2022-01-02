CREATE TABLE IF NOT EXISTS category (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title VARCHAR(25),
    description VARCHAR(10000)
);

Insert into category(title,description) values ('Tiên Hiệp','Truyện tiên hiệp thường kể về quá trình tu luyện và khám phá thế giới tu sĩ thần tiên đầy bí ẩn của nhân vật chính. Trong truyện tiên hiệp thường chia ra những cấp bậc tu luyện trước khi thành tiên như sau: Luyện Khí Khai Quang Trúc Cơ Ích Cốc Kết Đan (Kim Đan) Nguyên Anh Hóa Thần (Phân Thần) Hợp Thể Độ Kiếp Đại Thừa Sau khi thành tiên thì có những cấp bậc: Tán Tiên Tiên Nhân Địa Tiên Thiên Tiên Thượng Tiên Kim Tiên Huyền Tiên Đại La Kim Tiên Tiên Vương Tiên Tôn Tiên Đế Ngoài ra còn có những cấp độ ngoài tiên như Bán Thánh, Vô Cực Thánh Nhân,.. dựa theo trí tưởng tượng của tác giả.');
Insert into category(title,description) values ('Kiếm Hiệp','Truyện thường xoay quanh cuộc đời của nhân vật chính, quá trình rèn luyện, trưởng thành, tìm kiếm, học tập các bí kíp võ công, cùng những cuộc phiêu lưu, truy đuổi, chém giết... đầy nguy hiểm và cơ hội trong giới võ lâm giang hồ.');
Insert into category(title,description) values ('Ngôn Tình','Truyện thuộc kiểu lãng mạn, kể về những sự kiện vui buồn trong tình yêu của nhân vật chính.');
Insert into category(title,description) values ('Đô Thị','Những truyện có nội dung chủ yếu diễn ra trong môi trường đô thị hiện đại.');
Insert into category(title,description) values ('Quan Trường','Là truyện kể về những khía cạnh cũng như quá trình thăng quan tiến chức của nhân vật chính trong chính trường.');
Insert into category(title,description) values ('Võng Du','Là thể loại truyện thuộc dạng khoa học viễn tượng, lấy bối cảnh thường là các game online trên mạng với công nghệ cao, hình ảnh chất lượng cao, kỹ xảo đồ sộ, mức chân thật cao, kỳ ảo, và tác giả của thể loại này thường rất giàu trí tưởng tượng :))');
Insert into category(title,description) values ('Khoa Huyền','Những bộ truyện có yếu tố khoa học bí ẩn.');
Insert into category(title,description) values ('Huyễn Huyền','Truyện có những yếu tố huyền bí, khoa học khó giải thích.');
Insert into category(title,description) values ('Dị Giới','Trong truyện có xuất hiện những thế giới kỳ dị, khác với thế giới chúng ta đang sinh sống.');
Insert into category(title,description) values ('Dị Năng','Truyện dị năng là thể loại thường có những nhân vật sở hữu các năng lực siêu nhiên đặc biệt mà người thường không thể nào có được.');
Insert into category(title,description) values ('Quân Sự','Truyện có yếu tố quân sự, thường diễn ra trong môi trường quân đội, quân lính.');
Insert into category(title,description) values ('Lịch Sử','Nội dung truyện thường xảy ra trong lịch sử, có nhiều yếu tố tương tự so với lịch sử thế giới thật.');
Insert into category(title,description) values ('Xuyên Không','Xuyên Không, Xuyên Việt là thể loại nhân vật chính vì một lý do nào đó mà bị đưa đến sinh sống ở một không gian hay một khoảng thời gian khác. Nhân vật chính có thể trực tiếp xuyên qua bằng thân xác mình hoặc sống lại bằng thân xác người khác.');
Insert into category(title,description) values ('Trọng Sinh','Đây là thể truyện có nhân vật chính vì một lý do nào đó mà được sống lại sau khi chết đi, thể loại này thường kết hợp với thể loại xuyên không.');
Insert into category(title,description) values ('Trinh Thám','Thể loại truyện trinh thám');
Insert into category(title,description) values ('Thám Hiểm','Nội dung truyện thường là những cuộc phiêu lưu thám hiểm những địa danh kỳ bí cực gay cấn.');
Insert into category(title,description) values ('Linh Dị','Truyện có nhiều yếu tố ma quỷ rùng rợn, kinh dị.');
Insert into category(title,description) values ('Truyện Sắc','Những bộ truyện này thường có yếu nhạy cảm, cân nhắc trước khi xem.');
Insert into category(title,description) values ('Tuyện Ngược','Truyện ngược là thể loại truyện có những tình tiết khiến người xem xúc động mạnh, thường là tức giận, luyến tiếc thậm chí là ức chế thay cho nhân vật, khi mà họ bị hành hạ về mặt thể xác hoặc tinh thần.');
Insert into category(title,description) values ('Truyện Sủng','Ngược với truyện ngược, truyện sủng là thể loại truyện khiến người đọc có cảm giác ngọt ngào vui vẻ, nơi mà nhân vật chính được nửa kia của mình quan tâm và cưng chiều hết mình.');
Insert into category(title,description) values ('Truyện Cung Đấu','Truyện cung đấu là thể loại truyện có các nhân vật trong hoàng cung thời phong kiến đấu đá, âm mưu tính toán lẫn nhau.');
Insert into category(title,description) values ('Truyện Nữ Cường','Truyện nữ cường là thể loại truyện có những nhân vật nữ sở hữu tính cánh mạnh mẽ (có khi hơn cả đàn ông).');
Insert into category(title,description) values ('Truyện Gia Đầu','Gia đấu cũng như trạch đấu là thể loại truyện có các tình tiết đấu đá, mưu tính nhau giữa các thành viên trong gia đình hoặc dòng họ.');
Insert into category(title,description) values ('Đông Phương','Là những truyện có nội dung xảy ra ở các nước phương Đông.');
Insert into category(title,description) values ('Đam Mĩ','Truyện tình cảm giữa nam và nam.');
Insert into category(title,description) values ('Bách Hớp','Truyện tình cảm giữa nữ và nữ.');
Insert into category(title,description) values ('Hài Hước','Những bộ truyện có nội dung hài hước, đem lại tiếng cười vui vẻ cho độc giả.');
Insert into category(title,description) values ('Điền Văn','Điền văn, hay còn gọi là văn cày ruộng là thể loại truyện cho những bạn thích những câu chuyện nhẹ nhàng, đơn giản. Truyện điền văn kể về cuộc sống điền viên, chăm sóc ruộng vườn nhà cửa của nhân vật chính. Truyện thể loại này thường không có cao trào, nút thắt, tranh đấu, tuy nhiên vẫn có một số ngoại lệ.');
Insert into category(title,description) values ('Cổ Đại','Truyện có nội dung xảy ra ở thời cổ đại phong kiến.');
Insert into category(title,description) values ('Mạt Thế','Là truyện có bối cảnh tận thế, thế giới bị sụp đổ và diệt vong vì những thảm họa.');
Insert into category(title,description) values ('Truyện Teen','Truyện teen là thể loại truyện được viết dành riêng cho lứa tuổi thanh thiếu niên mới lớn, tâm hồn đầy hồn nhiên và mộng mơ. Truyện thường tả về các mỗi tình tuổi học trò đầy hồn nhiên và tươi sáng.');
Insert into category(title,description) values ('Phương Tây','Những tác phẩm được viết bởi các tác giả phương Tây.');
Insert into category(title,description) values ('Nữ Phụ','Truyện kể về nhân vật chính là... nữ phụ trong các tiểu thuyết.');
Insert into category(title,description) values ('Light Novel','Light Novel là một dạng tiểu thuyết Nhật Bản được viết nhằm chủ yếu hướng đến các độc giả trẻ như học sinh trung học. Dạng tiểu thuyết đang lan rộng và được giới tác giả cũng như độc giả trên thế giới đón nhận nồng nhiệt.');
Insert into category(title,description) values ('Việt Nam','Các tác phẩm của nền văn học Việt Nam, được viết bởi các danh tác nổi tiếng.');
Insert into category(title,description) values ('Đoản Văn','Truyện đoản văn là những truyện có nội dung ngắn, thưởng chỉ có một đến vài chương.');
Insert into category(title,description) values ('Truyện Khác','Những truyện không thuộc những thể loại đã có ở Truyện Full sẽ "được" nhét vào đây.');

