/*
drop database if exists hustmilktea;
create database hustmilktea;
 */

drop table if exists ToppingTrongHoaDon
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
    constraint check_trangthai check ( trangThai = 'Dang chuan bi' or trangThai = 'Da giao' )
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
    constraint fk_thanhphanhoadon_giadouong foreign key (tenDoUong, size) references GiaDoUong(tenDoUong, size),
    constraint fk_thanhphanhoadon_topping foreign key (tenTopping) references Topping(tenTopping)
);

create table ToppingTrongHoaDon (
    maHoaDon        varchar(20) not null,
    buyID           int not null,
    tenTopping      varchar(20),
    constraint pk_thanhphanhoadon primary key (maHoaDon, buyID, tenTopping),
    constraint fk_toppingtronghoadon_thanhphanhoadon foreign key (maHoaDon, buyID) references ThanhPhanHoaDon(maHoaDon, buyID),
    constraint fk_toppingtronghoadon_topping foreign key (tenTopping) references Topping(tenTopping),
);











