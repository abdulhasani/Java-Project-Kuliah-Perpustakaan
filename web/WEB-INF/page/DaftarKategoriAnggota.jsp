<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>



        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>Perpustakaan Smart</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    </head>
    <body>
        <center>
            <marquee behavior="scroll" direction="left"><font face="Arial Black, Gadget, sans-serif" size="+3">SELAMAT DATANG
                    DIPERPUSTAKAAN SMART</font></marquee>
            <img src="img/perpustakaan.jpg" width="1032" height="233" border="1" align="top" style="width: 1005px; height: 213px;" /><br />
            <table width="1002" height="370" border="0" bgcolor="#EFEFEF" style="width: 1007px; height: 254px;">
                <!--MENU--> <tbody>
                    <tr valign="top">
                        <td align="left" height="28" width="996">
                            <table style="width: 999px; height: 35px; background-color: rgb(102, 102, 102);" border="1">
                                <tbody>
                                    <tr valign="top">
                                        <td width="231">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=homeAdmin"><font color="#ff0000" size="+1">
                                                        <b>HOME</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="191"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarAnggota"><b><font color="#ff0000" size="+1">ANGGOTA</font></b></a></div></td>
                                        <td width="171"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarPeminjaman"><b><font color="#ff0000" size="+1">TRANSAKSI</font></b></a></div></td>
                                        <td width="122">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=daftarBukuAdmin"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="250">
                                            <div align="center"><a href="controler?/san/jmat/perpus/action=daftarPengembalian"><b><font color="#ff0000" size="+1">MANAGER MENU</font></b></a></div>
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
                            <table width="970" border="0" cellpadding="1" cellspacing="2" style="width: 995px; height: 201px;">
                                <tbody>
                                    <tr>
                                        <td height="280" valign="top" width="410">
                                            <form id="form1" name="form1" method="post" action="">
                                                <center>
                                                    <p>&nbsp;</p>
                                                    <table width="406" height="109" border="1">
                                                        <tr>
                                                            <td width="396"><table width="387" border="1" style="width: 400px; height: 193px;">
                                                                    <tbody>
                                                                        <tr valign="top">
                                                                            <td width="377" style="width: 282px; background-color: rgb(239,239,239);"><br />
                                                                                <table width="240" style="width: 381px; height: 163px; background-color: rgb(239,239,239); text-align: left; margin-left: auto; margin-right: auto; color: #F00;">
                                                                                    <tbody>
                                                                                        <tr style="color: yellow; font-weight: bold;">
                                                                                            <td colspan="3" style="text-align: center; color: #00F;">PROFILE</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="105" height="38" style="color: #00F; font-weight: bold;">User Name</td>
                                                                                            <td style="color: rgb(0,0,255); font-weight: bold;" width="13"><div align="center">:</div></td>
                                                                                            <td style="color: darkorange; font-weight: bold;"width="247">${login.userName}</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td></td>
                                                                                            <td></td>
                                                                                            <td>Edit Tambah <a href="controler?/san/jmat/perpus/action=loginFinish">Keluar</a></td>
                                                                                        </tr>
                                                                                        <tr style="color: red;">
                                                                                            <td colspan="3" align="center">Enjoy Login</td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table></td>
                                                        </tr>
                                                    </table>
                                                    <p>&nbsp;</p>
                                                    <p>&nbsp;</p>
                                                </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="575"><div align="center"><br />
                                                <table width="559" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                    <tbody>
                                                        <tr>
                                                            <td align="center" valign="top" width="555"><font style="color: #000000;" size="+1">DAFTAR KATEGORI ANGGOTA<br />
                                                                </font>
                                                                <div style="text-align: left;">
                                                                    <table width="552" height="46" border="1">
                                                                        <form id="form2" name="form2" method="post" action="controler?/san/jmat/perpus/action=searchBukuAdmin">
                                                                            <san:if test="${msg2!=null}">
                                                                                <tr>
                                                                                    <td colspan="3" style="color: red"><div align="center"><b>${msg2}</b></div></td>
                                                                                </tr>
                                                                            </san:if>
                                                                        </form>
                                                                        <tr>
                                                                            <td style="color:#000000" ><div align="center">NAMA</div></td>
                                                                            <td style="color:#000000"><div align="center">KETERANGAN</div></td>
                                                                            <td style="color:#000000"><div align="center">EVENT</div></td>
                                                                        </tr>

                                                                        <san:forEach items="${anggotas}" var="anggota">
                                                                            <tr>
                                                                                <td width="151" style="color:#000000" ><div align="left">${anggota.nama}</div></td>
                                                                                <td width="223" style="color:#000000"><div align="left">${anggota.keterangan}</div></td>
                                                                                <td width="137" style="color:#000000"><div align="center">&nbsp;<a href="controler?/san/jmat/perpus/action=crudKategoriAnggota&idKtgAnggota=${anggota.idKategoriAnggota}">EDIT</a> &nbsp;<a href="controler?/san/jmat/perpus/action=deleteKategoriAnggota&idKtgAnggota=${anggota.idKategoriAnggota}">DELETE</a></div></td>
                                                                            </tr>
                                                                        </san:forEach>

                                                                        <tr>
                                                                            <td colspan="3"><div align="center"><a href="controler?/san/jmat/perpus/action=crudKategoriAnggota&idKtgAnggota="><font color="blue">ADD</font></a></div></td>
                                                                        </tr>
                                                                    </table>

                                                                </div>
                                                                <font color="yellow">
                                                                </font></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                &nbsp;
                                                <br />
                                            </div>
                                            <div align="center"></div></td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br />

        </center>

    </body></html>