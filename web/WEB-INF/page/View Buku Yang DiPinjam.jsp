<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>Perpustakaan Smart</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    </head>
    <body>
        <center>
            <marquee behavior="scroll" direction="left"><font face="Arial Black, Gadget, sans-serif" size="+3">SELAMAT DATANG
                    DIPERPUSTAKAAN SMART</font></marquee>
            <img style="width: 1005px; height: 213px;" src="img/perpustakaan.jpg" align="top" border="1" />
            <br />
            <table style="width: 1007px; height: 254px;" bgcolor="#333333" border="0">
                <!--MENU--> <tbody>
                    <tr valign="top">
                        <td align="left" height="28" width="861">
                            <table style="width: 999px; height: 35px; background-color: rgb(102, 102, 102);" border="1">
                                <tbody>
                                    <tr valign="top">
                                        <td width="259">
                                            <div align="center"> <a href="controler?/san/jmat/perpus/action=homeAdmin"><font color="#ff0000" size="+1">
                                                        <b>HOME</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="321"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarAnggota"><b><font color="#ff0000" size="+1">ANGGOTA</font></b></a></div></td>
                                        <td width="321"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarPeminjaman"><b><font color="#ff0000" size="+1">TRANSAKSI</font></b></a></div></td>
                                        <td width="321">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=daftarBukuAdmin"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="262">
                                            <div align="center"><a href="controler?/san/jmat/perpus/action=daftarPengembalian"><b><font color="#ff0000" size="+1">MANAGER MENU</font></b></a></</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                    <tr valign="top">
                        <td height="161">
                            <table style="width: 995px; height: 201px;" border="0" cellpadding="1" cellspacing="2">
                                <tbody>
                                    <tr>
                                        <td height="157" valign="top" width="318">
                                            <form id="form1" name="form1" method="post" action="">
                                                <table style="width: 417px; height: 189px;">
                                                    <tbody>
                                                        <tr valign="top">
                                                            <td style="width: 282px; background-color: rgb(51, 51, 51);"><br />
                                                                <table style="width: 400px; height: 193px;" border="1">
                                                                    <tbody><tr valign="top"><td style="width: 282px; background-color: rgb(51, 51, 51);"><br />

                                                                                <table style="width: 381px; height: 163px; background-color: rgb(65, 65, 65); text-align: left; margin-left: auto; margin-right: auto;">
                                                                                    <tbody>
                                                                                        <tr style="color: yellow; font-weight: bold;">
                                                                                            <td colspan="3" style="text-align: center;">PROFILE</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td style="color: yellow; font-weight: bold;" width="78">User Name</td>
                                                                                            <td style="color: rgb(255, 255, 51); font-weight: bold;" width="3">:</td>
                                                                                            <td style="color: darkorange; font-weight: bold;"width="213">${login.userName}</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td></td>
                                                                                            <td></td>
                                                                                            <td>
                                                                                                <table width="262" border="0">
                                                                                                    <tr>
                                                                                                        <td width="91"><a href=""><dir align="center"><strong><font color="#FFFF00">Edit</font></strong></dir></a></td>
                                                                                                        <td width="82"><a href=""><dir align="center"><strong><font color="#FFFF00">Tambah</font></strong></dir></a></td>
                                                                                                        <td width="75"><a href="controler?/san/jmat/perpus/action=loginFinish"><dir align="center"><strong><font color="#FFFF00">Keluar</font></strong></dir></a></td>
                                                                                                    </tr> 
                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr style="color: red;">
                                                                                            <td colspan="3" align="center">Enjoy Login</td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table>
                                                                            </td></tr></tbody>
                                                                </table>
                                                                <br />
                                                            </td>
                                                            <!--Akhir Login--> </tr>
                                                    </tbody>
                                                </table>
                                                <center> </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="511"><br />
                                            <table style="width: 553px; height: 62px;" border="0" cellpadding="0" cellspacing="2">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="519"> <font color="yellow"><font style="color: yellow;" size="+1"><span style="font-family: Nimbus Sans L;">PERPUSTAKAAN
                                                                        SMART</span><br />
                                                                </font></font>
                                                            <div style="text-align: left;">
                                                                <form action="controler?/san/jmat/perpus/action=pengembalianBuku&noAnggota=${nomorAnggota}" method="post">
                                                                    <table width="445" border="0" style="color:#FF0">
                                                                        <san:if test="${msg2!=null}">
                                                                                <tr>
                                                                                    <td colspan="3" style="color: red">&nbsp;</td>
                                                                                </tr>
                                                                    </san:if>
                                                                    <tr>
                                                                        <td>Nomor Anggota</td>
                                                                        <td><div align="center">:</div></td>
                                                                        <td>${nomorAnggota}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td width="171">Buku Yang DiPinjam</td>
                                                                        <td width="12"><div align="center">:</div></td>
                                                                        <td width="248">&nbsp;</td>
                                                                    </tr>
                                                                        <san:forEach items="${judulBuku}" var="judul">
                                                                    <tr>
                                                                        <td>&nbsp;</td>
                                                                        <td><div align="center"></div></td>
                                                                        <td>${judul.judulBuku}</td>
                                                                    </tr>
                                                                        </san:forEach>
                                                                    <tr>
                                                                        <td>&nbsp;</td>
                                                                        <td><div align="center"></div></td>
                                                                        <td><input type="submit" name="Submit" id="button" value="Kembalikan Semua Buku" /></td>
                                                                    </tr>
                                                                </table>
                                                            </form>
                                                            <font style="font-family: Comic Sans MS;" color="yellow"><font style="color: yellow;" size="+1"><br />
                                                                </font></font>
                                                            <div style="text-align: center;"><br />
                                                                <font style="font-family: Comic Sans MS;" color="yellow"><font style="color: yellow;" size="+1">
                                                                    </font></font></div>
                                                        </div>
                                                        <font color="yellow">
                                                        </font></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        &nbsp;
                                        <br />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table><br />

    </center>

</body></html>