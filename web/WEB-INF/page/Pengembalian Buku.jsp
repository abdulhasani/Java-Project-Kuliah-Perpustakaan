<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>



        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>Perpustakaan Smart</title>

        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    </head>
    <body>
        <center>
            <marquee behavior="scroll" direction="left"><font face="Arial Black, Gadget, sans-serif" size="+3">SELAMAT DATANG
                    DIPERPUSTAKAAN SMART</font></marquee>
            <br />
            <table width="1020" border="0" bgcolor="#333333" style="width: 1007px; height: 254px;">
                <!--MENU--> <tbody>
                    <tr valign="top">
                        <td align="left" height="28" width="1014" valign="top">

                            <table width="1006" border="1" style="width: 999px; height: 35px; background-color: rgb(102, 102, 102);">

                                <tbody>
                                    <tr valign="top">
                                        <td colspan="5"><img src="img/perpustakaan.jpg" alt="" border="1" align="top" style="width: 1005px; height: 213px;" /></td>
                                    </tr>
                                    <tr valign="top">
                                        <td width="171">
                                            <div align="center"> <a href="controler?/san/jmat/perpus/action=homeAdmin"><font color="#ff0000" size="+1">
                                                        <b>HOME</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="213"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarAnggota"><b><font color="#ff0000" size="+1">ANGGOTA</font></b></a></div></td>
                                        <td width="213"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarPeminjaman"><b><font color="#ff0000" size="+1">TRANSAKSI</font></b></a></div></td>
                                        <td width="213">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=daftarBukuAdmin"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>

                                        </td>
                                        <td width="162">
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
                            <table width="986" border="0" cellpadding="1" cellspacing="2" style="width: 995px; height: 201px;">
                                <tbody>
                                    <tr>
                                        <td height="157" valign="top" width="426">
                                            <form id="form1" name="form1" method="post" action="">
                                                <table width="404" height="272" style="width: 417px; height: 189px;">
                                                    <tbody>
                                                        <tr valign="top">
                                                            <td width="396" style="width: 282px; background-color: rgb(51, 51, 51);"><br />
                                                                <table style="width: 400px; height: 193px;" border="1">
                                                                    <tbody>
                                                                        <tr valign="top">
                                                                            <td style="width: 282px; background-color: rgb(51, 51, 51);"><br />
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
                                                                                            <td><table width="262" border="0">
                                                                                                    <tr>
                                                                                                        <td width="91"><a href=""><dir align="center"><strong><font color="#FFFF00">Edit</font></strong></dir></a></td>
                                                                                                        <td width="82"><a href=""><dir align="center"><strong><font color="#FFFF00">Tambah</font></strong></dir></a></td>
                                                                                                        <td width="75"><a href="controler?/san/jmat/perpus/action=loginFinish"><dir align="center"><strong><font color="#FFFF00">Keluar</font></strong></dir></a></td>
                                                                                                    </tr>
                                                                                                </table></td>
                                                                                        </tr>
                                                                                        <tr style="color: red;">
                                                                                            <td colspan="3" align="center">Enjoy Login</td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>                                                              <br />
                                                            </td>
                                                            <!--Akhir Login--> </tr>
                                                    </tbody>
                                                </table>
                                                <center> </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="550"><br />
                                            <table width="398" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="463"> <font color="yellow"><font style="color: yellow;" size="+1"><span style="font-family: Nimbus Sans L; font-size: 24px;">PERPUSTAKAAN
                                                                        SMART</span><br />
                                                                </font></font>
                                                            <div style="text-align: left; color: #FF0; font-size: 18px;">
                                                                <san:if test="${nyicil==null}">
                                                                    <form id="form2" name="form2" method="post" action="controler?/san/jmat/perpus/action=pengembalianBukuFinish&noAnggota=${nomorAnggota}">
                                                                    </san:if>
                                                                    <san:if test="${nyicil!=null}">
                                                                        <form id="form2" name="form2" method="post" action="controler?/san/jmat/perpus/action=pengembalianBukuFinish&idPeminjam=${nyicil}">
                                                                        </san:if>
                                                                        <div align="left">
                                                                            <table width="532" border="0">
                                                                                <san:if test="${pesan!=null}">
                                                                                    <tr><td colspan="3"><div align="center"><font color="red">${pesan}</font></div></td></tr>
                                                                                </san:if>
                                                                                <tr>
                                                                                    <td width="209">Nomor Anggota</td>
                                                                                    <td width="9"><div align="center">:</div></td>
                                                                                    <td width="194"><label for="nomorAnggota"></label>${nomorAnggota}</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Jumlah Item</td>
                                                                                    <td><div align="center">:</div></td>
                                                                                    <td> ${jmlhItem} Buku </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Judul Buku</td>
                                                                                    <td><div align="center">:</div></td>
                                                                                    <td>&nbsp;</td>
                                                                                </tr>
                                                                                <san:forEach items="${peminjaman}" var="pmj">
                                                                                    <tr>
                                                                                        <td></td>
                                                                                        <td></td>
                                                                                        <td>${pmj.judulBuku}</td>
                                                                                        <td><fmt:formatDate value="${pmj.tanggalHarusKembali}" type="date" /></td>
                                                                                    </tr>
                                                                                </san:forEach>

                                                                                <tr>
                                                                                    <td>Di Kembalikan Tanggal </td>
                                                                                    <td><div align="center">:</div></td>
                                                                                    <td><label for="dd"></label>
                                                                                        <input name="dd" type="text" id="dd" size="3" maxlength="2" value="${tgl}" align="center"/> 
                                                                                        -
                                                                                        <label for=""></label>
                                                                                        <input name="MM" type="text" id="MM" size="3" maxlength="2" value="${bln}"align="center"/>
                                                                                        -
                                                                                        <label for="yyyy"></label>
                                                                                        <input name="yyyy" type="text" id="yyyy" size="5" maxlength="4" value="${thn}" align="center"/></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td><input type="submit" name="button2" id="button2" value="Kembalikan Buku" /></td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                        <p>&nbsp;</p>

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