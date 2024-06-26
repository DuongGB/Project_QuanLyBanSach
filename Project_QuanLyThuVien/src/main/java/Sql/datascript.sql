USE [QuanLyBanSach]
GO
SET IDENTITY_INSERT [dbo].[DanhMucSanPham] ON 

INSERT [dbo].[DanhMucSanPham] ([MaDanhMuc], [TenDanhMuc]) VALUES (10, N'Sách')
INSERT [dbo].[DanhMucSanPham] ([MaDanhMuc], [TenDanhMuc]) VALUES (11, N'Văn Phòng Phẩm')
SET IDENTITY_INSERT [dbo].[DanhMucSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[TheLoai] ON 

INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai], [MaDanhMuc]) VALUES (4, N'Sách Lập Trình', 10)
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai], [MaDanhMuc]) VALUES (5, N'Bút', 11)
SET IDENTITY_INSERT [dbo].[TheLoai] OFF
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [GioiTinh], [SoDienThoai], [NgaySinh], [DiemDoiThuong]) VALUES (N'KH-1201        ', N'Võ Ngọc Thắng', 0, N'0704462651', CAST(N'2012-12-14' AS Date), 5400)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [GioiTinh], [SoDienThoai], [NgaySinh], [DiemDoiThuong]) VALUES (N'KH-2302        ', N'Ngọc Hưng', 0, N'0704462655', CAST(N'2023-12-04' AS Date), 3553)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [GioiTinh], [SoDienThoai], [NgaySinh], [DiemDoiThuong]) VALUES (N'KH-2303        ', N'Thắng', 0, N'0704462651', CAST(N'2023-12-04' AS Date), 0)
GO
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [TrangThai], [ChucVu], [LuongCoBan], [NgayVaoLam]) VALUES (N'NV-0301        ', N'Võ Ngọc Thắng', CAST(N'2003-09-08' AS Date), 1, N'0704462651', N'Hồ Chí Minh', 1, N'1', 2000000000, CAST(N'2023-12-03' AS Date))
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [TrangThai], [ChucVu], [LuongCoBan], [NgayVaoLam]) VALUES (N'NV-0802        ', N'Nguyễn Văn Thắng', CAST(N'2008-12-12' AS Date), 0, N'0704462652', N'HCM', 0, N'0', 200000000, CAST(N'2023-12-03' AS Date))
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HD-04122300    ', CAST(N'2023-12-04' AS Date), N'KH-2302        ', N'NV-0802        ')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HD-04122301    ', CAST(N'2023-12-04' AS Date), NULL, N'NV-0802        ')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HD-04122302    ', CAST(N'2023-12-04' AS Date), NULL, N'NV-0802        ')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HD-04122303    ', CAST(N'2023-12-04' AS Date), NULL, N'NV-0802        ')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HD-04122304    ', CAST(N'2023-12-04' AS Date), NULL, N'NV-0802        ')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HD-04122305    ', CAST(N'2023-12-04' AS Date), N'KH-2302        ', N'NV-0802        ')
GO
INSERT [dbo].[TaiKhoan] ([TenTaiKhoan], [MatKhau], [MaNhanVien], [Role]) VALUES (N'0704462651', N'1', N'NV-0301        ', N'QL')
INSERT [dbo].[TaiKhoan] ([TenTaiKhoan], [MatKhau], [MaNhanVien], [Role]) VALUES (N'0704462652', N'123456789', N'NV-0802        ', N'BH')
GO
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [GiaMua], [HinhAnh], [MaNhaCungCap], [MaTacGia], [SoTrang], [MaTheLoai], [MoTa], [MaNXB], [soLuongTon], [VAT]) VALUES (N'SP-00          ', N'HTML5 & CSS3', 99000, N'src\Img\HTML, CSS.jpg', N'NCC-2300       ', N'TG-2300        ', 236, 4, N'Sách học lập trình giao diện web cơ bản', N'NXB-2300', 46, 0.08)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [GiaMua], [HinhAnh], [MaNhaCungCap], [MaTacGia], [SoTrang], [MaTheLoai], [MoTa], [MaNXB], [soLuongTon], [VAT]) VALUES (N'SP-01          ', N'Javascript căn bản', 120000, N'src\Img\JS.png', N'NCC-2300       ', N'TG-2300        ', 132, 4, N'Học lập trình sự kiện cho ứng dụng web', N'NXB-2300', 95, 0.08)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [GiaMua], [HinhAnh], [MaNhaCungCap], [MaTacGia], [SoTrang], [MaTheLoai], [MoTa], [MaNXB], [soLuongTon], [VAT]) VALUES (N'SP-02          ', N'Java căn bản', 50000, N'src\Img\Java.jpg', N'NCC-2300       ', N'TG-2301        ', 200, 4, N'Học lập trình Java căn bản cho người mới', N'NXB-2300', 58, 0.08)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [GiaMua], [HinhAnh], [MaNhaCungCap], [MaTacGia], [SoTrang], [MaTheLoai], [MoTa], [MaNXB], [soLuongTon], [VAT]) VALUES (N'SP-03          ', N'Kỹ thuật lập trình C', 60000, N'src\Img\KTLT.jpg', N'NCC-2300       ', N'TG-2301        ', 100, 4, N'Kỹ thuật lập trình với  ngôn ngữ C', N'NXB-2300', 19, 0.08)
GO
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122300    ', N'SP-00          ', 99000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122300    ', N'SP-01          ', 120000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122301    ', N'SP-02          ', 50000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122302    ', N'SP-01          ', 120000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122303    ', N'SP-01          ', 120000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122304    ', N'SP-00          ', 99000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122305    ', N'SP-00          ', 99000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122305    ', N'SP-01          ', 120000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122305    ', N'SP-02          ', 50000)
INSERT [dbo].[ChiTietHoaDon] ([SoLuong], [MaHoaDon], [MaSanPham], [GiaBan]) VALUES (1, N'HD-04122305    ', N'SP-03          ', 60000)
GO
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [DiachiNCC], [SoDienThoai]) VALUES (N'NCC-2300       ', N'FPT University', N'Quận 1, TPHCM', N'0704465868')
GO
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChiNXB], [SoDienThoai]) VALUES (N'NXB-2300', N'FPT University', N'Quận 1, TPHCM', N'0704465235      ')
GO
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGIa], [SoDienThoai], [GioiTinh]) VALUES (N'TG-2300        ', N'Lê Hoàng Giang', N'0704462658  ', 0)
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGIa], [SoDienThoai], [GioiTinh]) VALUES (N'TG-2301        ', N'Trần Tấn Minh Đạo', N'0704462659  ', 0)
GO
