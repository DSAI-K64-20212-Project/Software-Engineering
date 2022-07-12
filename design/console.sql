/*
drop database if exists hustmilktea;
create database hustmilktea;
*/

drop table if exists ToppingTrongHoaDon;
drop table if exists ThanhPhanHoaDon;
drop table if exists HoaDon;
drop table if exists ThanhPhanTopping;
drop table if exists Topping;
drop table if exists ThanhPhanDoUong;
drop table if exists GiaDoUong;
drop table if exists DoUong;
drop table if exists NguyenLieu;
drop table if exists LichSuLamViec;
drop table if exists NhanVien;
drop table if exists TienLuong;

create table TienLuong (
    chucVu      varchar(20) not null,
    caLam       varchar(20) not null,
    tienCaLam   int         not null,
    constraint pk_tienluong primary key (chucVu, caLam),
    constraint check_chucvu check ( chucVu = 'Quan Ly' or chucVu = 'Thu Ngan' or chucVu = 'Pha Che' ),
    constraint check_calam check ( caLam = 'Sang' or caLam = 'Chieu' )
);

create table NhanVien (
    tenDangNhap     varchar(20) not null,
    tenNhanVien     varchar(20) not null,
    sdt             varchar(10) not null,
    matKhau         varchar(20) not null,
    anhDaiDien      varchar(20) not null,
    chucVu          varchar(20) not null,
    caLam           varchar(20) not null,
    constraint pk_nhanvien primary key (tenDangNhap),
    constraint fk_nhanvien_tienluong foreign key (chucVu, caLam) references TienLuong(chucVu, caLam)
);

create table LichSuLamViec (
    tenDangNhap     varchar(20) not null,
    ngayLam         date        not null,
    daTraLuong      bool        not null,
    constraint pk_lichsulamviec primary key (tenDangNhap, ngayLam),
    constraint fk_lichsulamviec_nhanvien foreign key (tenDangNhap) references NhanVien(tenDangNhap)
);

create table NguyenLieu (
    tenNguyenLieu   varchar(20) not null,
    nhaCungCap      varchar(20) not null,
    trangThai       varchar(20) not null,
    constraint pk_nguyenlieu primary key (tenNguyenLieu),
    constraint check_trangthai check ( trangThai = 'Con hang' or trangThai = 'Sap het' or trangThai = 'Het hang' )
);

create table DoUong (
    tenDoUong   varchar(20) not null,
    anh         varchar(20) not null,
    constraint pk_douong primary key (tenDoUong)
);

create table GiaDoUong (
    tenDoUong   varchar(20) not null,
    size        varchar(1)  not null,
    giaDoUong   int,
    constraint pk_giadouong primary key (tenDoUong, size),
    constraint fk_giadouong_douong foreign key (tenDoUong) references DoUong(tenDoUong),
    constraint check_size check ( size = 'M' or size = 'L' )
);

create table ThanhPhanDoUong (
    tenDoUong       varchar(20) not null,
    tenNguyenLieu   varchar(20) not null,
    constraint pk_thanhphandouong primary key (tenDoUong, tenNguyenLieu),
    constraint fk_thanhphandouong_douong foreign key (tenDoUong) references DoUong(tenDoUong),
    constraint fk_thanhphandouong_nguyenlieu foreign key (tenNguyenLieu) references NguyenLieu(tenNguyenLieu)
);

create table Topping (
    tenTopping  varchar(20) not null,
    giaTopping  int,
    anh         varchar(20) not null,
    constraint pk_topping primary key (tenTopping)
);

create table ThanhPhanTopping (
    tenTopping      varchar(20) not null,
    tenNguyenLieu   varchar(20) not null,
    constraint pk_thanhphantopping primary key (tenTopping, tenNguyenLieu),
    constraint fk_thanhphantopping_topping foreign key (tenTopping) references Topping(tenTopping),
    constraint fk_thanhphantopping_nguyenlieu foreign key (tenNguyenLieu) references NguyenLieu(tenNguyenLieu)
);

create table HoaDon (
    maHoaDon        varchar(20) not null,
    tenKhachHang    varchar(20) not null,
    tenDangNhap     varchar(20) not null,
    soOrder         int         not null,
    khachDua        int         not null,
    trangThai       varchar(20) not null,
    thoigian        date        not null,
    constraint pk_hoadon primary key (maHoaDon),
    constraint fk_hoadon_nhanvien foreign key (tenDangNhap) references NhanVien(tenDangNhap),
   traint check_trangthai check ( trangThai = 'Dang chuan bi' or trangThai = 'Da giao' or trangThai= 'Huy')
);

create table ThanhPhanHoaDon (
    maHoaDon        varchar(20) not null,
    buyID           SERIAL not null,
    tenDoUong       varchar(20) not null,
    size            varchar(1)  not null,
    da              int,
    duong           int,
    soLuong         int         not null,
    constraint pk_thanhphanhoadon primary key (maHoaDon, buyID),
    constraint fk_thanhphanhoadon_hoadon foreign key (maHoaDon) references HoaDon(maHoaDon),
    constraint fk_thanhphanhoadon_giadouong foreign key (tenDoUong, size) references GiaDoUong(tenDoUong, size)
);

create table ToppingTrongHoaDon (
    maHoaDon        varchar(20) not null,
    buyID           int not null,
    tenTopping      varchar(20),
    constraint pk_toppingtronghoadon primary key (maHoaDon, buyID, tenTopping),
    constraint fk_toppingtronghoadon_thanhphanhoadon foreign key (maHoaDon, buyID) references ThanhPhanHoaDon(maHoaDon, buyID),
    constraint fk_toppingtronghoadon_topping foreign key (tenTopping) references Topping(tenTopping)
);

TRUNCATE Table lichsulamviec, nhanvien, tienluong, hoadon, thanhphanhoadon, toppingtronghoadon;

INSERT INTO tienluong(chucvu, calam, tiencalam)
VALUES ('Quan Ly', 'Sang', 80),
       ('Quan Ly', 'Chieu', 100),
       ('Thu Ngan', 'Sang', 20),
       ('Thu Ngan', 'Chieu', 40),
       ('Pha Che', 'Sang', 30),
       ('Pha Che', 'Chieu', 50)
       ;

ALTER TABLE hoadon ALTER COLUMN mahoadon TYPE varchar(36);
ALTER TABLE thanhphanhoadon ALTER COLUMN mahoadon TYPE varchar(36);
ALTER TABLE toppingtronghoadon ALTER COLUMN mahoadon TYPE varchar(36);
ALTER TABLE thanhphanhoadon ALTER COLUMN da TYPE real;
ALTER TABLE thanhphanhoadon ALTER COLUMN duong TYPE real;
ALTER TABLE nguyenlieu ADD COLUMN anh varchar(20);
ALTER TABLE douong ADD COLUMN onmenu boolean;
ALTER TABLE topping ADD COLUMN onmenu boolean;
ALTER TABLE nhanvien ADD COLUMN active boolean;


ALTER TABLE hoadon ALTER Column thoigian type timestamp without time zone;
ALTER TABLE hoadon ALTER Column thoigian SET DEFAULT NOW() AT TIME ZONE 'WAST';
ALTER TABLE hoadon add Constraint check_trangthai check ( trangThai = 'Dang chuan bi' or trangThai = 'Da giao' or trangThai= 'Huy');

select date(thi.thoigian), sum(thanhtien) from (
                                                   select hoadon.thoigian, (sum(giaTopping) + giaDoUong)*soluong as thanhtien from hoadon
                                                                                                                                       inner join thanhphanhoadon t on hoadon.maHoaDon = t.mahoadon
                                                                                                                                       inner join giadouong GDU on GDU.tenDoUong = t.tenDoUong and GDU.size = t.size
                                                                                                                                       inner join toppingtronghoadon t2 on t.buyID = t2.buyid and t.maHoaDon = t2.maHoaDon
                                                                                                                                       inner join topping t3 on t2.tenTopping = t3.tentopping
                                                   group by hoadon.maHoaDon, t.buyID, giaDoUong, soluong
                                               ) as thi group by date(thi.thoigian);





CREATE OR REPLACE FUNCTION conversation_notify()
    RETURNS trigger AS
$BODY$
BEGIN
    PERFORM pg_notify('mymessage', 'fired by FUNCTION');
    --NOTIFY mymessage, 'fired by NOTIFY';
    RETURN NULL;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
                     COST 100;

CREATE TRIGGER douong_notify
    AFTER INSERT OR UPDATE
    ON douong
    EXECUTE PROCEDURE conversation_notify();

CREATE TRIGGER topping_notify
    AFTER INSERT OR UPDATE
    ON topping
EXECUTE PROCEDURE conversation_notify();

select 6*count(*) from lichsulamviec where tendangnhap = 'doubleK24' and ngaylam >= date_trunc('month', CURRENT_DATE);
select * from hoadon where thoigian::date = '2022-07-11' order by thoigian;

select * from douong where onmenu = True;
-- select n.tennguyenlieu, tenTopping from thanhphantopping inner join nguyenlieu n on ThanhPhanTopping.tenNguyenLieu = n.tennguyenlieu
-- where tenTopping in ('Hạt ngọc trai', 'Hạt châu xanh') and n.trangThai = 'Het hang'
-- union
-- select n2.tennguyenlieu, tenDoUong from thanhphandouong inner join nguyenlieu n2 on ThanhPhanDoUong.tenNguyenLieu = n2.tennguyenlieu
-- where tendouong = 'Trà sữa Hai Nắng' and n2.trangThai = 'Het hang';
-- ;
-- INSERT INTO nhanvien(tendangnhap, tennhanvien, matkhau, sdt, anhdaidien, chucvu, calam)
-- VALUES ('hungpham', 'Phạm Thành Hưng', '123456','0971169255','hung.png', 'Quan Ly', 'Sang');
--
-- INSERT INTO nguyenlieu(tenNguyenLieu, nhaCungCap, trangThai)
-- VALUES ('Trân Châu', 'CTy Trân Châu Hà Nội', 'Con hang');

-- SELECT * FROM nhanvien WHERE tendangnhap = 'hung' AND matkhau = 'u2ouofs';






