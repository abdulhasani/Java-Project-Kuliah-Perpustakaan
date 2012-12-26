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
                            <table width="986" border="0" cellpadding="1" cellspacing="2" style="width: 995px; height: 201px;">
                                <tbody>
                                    <tr>
                                        <td height="157" valign="top" width="426">
                                            <form id="form1" name="form1" method="post" action="controler?/san/jmat/perpus/action=searchPeminjamanBuku">
                                                <table width="404" height="272" style="width: 417px; height: 189px;">
                                                    <tbody>
                                                        <tr valign="top">
                                                            <td width="396" style="width: 282px; background-color: rgb(51, 51, 51);"><br />
                                                                <table width="387" border="0" style="width: 400px; height: 193px;">
                                                                    <tbody><tr valign="top"><td width="377" style="width: 282px; background-color: rgb(51, 51, 51);"><br />

                                                                                <table border="1" width="349" style="width: 381px; height: 163px; background-color: rgb(65, 65, 65); text-align: left; margin-left: auto; margin-right: auto; color: #FF0;">
                                                                                    <tbody>
                                                                                        <tr style="color: yellow; font-weight: bold;">
                                                                                            <td colspan="3" style="text-align: center;"><table width="321" border="0">

                                                                                                    <tr>
                                                                                                        <td width="230">
                                                                                                            <input name="cari" type="text" id="cari" size="30" maxlength="200" /></td>
                                                                                                        <td width="81"><div align="center">
                                                                                                                <input type="submit" name="button" id="button" value="Cari" size="20"/>
                                                                                                            </div></td>
                                                                                                    </tr>
                                                                                                </table></td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td style="color: yellow; font-weight: bold;" width="81"><div align="center">ID BUKU</div></td>
                                                                                            <td style="color: rgb(255, 255, 51); font-weight: bold;" width="225"><div align="center"><span style="color: yellow; font-weight: bold;">JUDUL BUKU</span></div></td>
                                                                                            <td style="color: #FF0; font-weight: bold;"width="59"><div align="center">P</div></td>
                                                                                        </tr>
                                                                                        <san:forEach items="${buku}" var="bk">
                                                                                            <tr>
                                                                                                <td><div align="center">${bk.idBuku}</div></td>
                                                                                                <td>${bk.judul}</td>
                                                                                                <td><div align="center"><san:if test="${keranjangFull==null}"><a href="controler?/san/jmat/perpus/action=keranjangPeminjamanBuku&idBuku=${bk.idBuku}"><strong><font color="yellow">P</font></strong></a></san:if></div></td>
                                                                                            </tr>
                                                                                            
                                                                                        </san:forEach>
                                                                                        <tr>
                                                                                                
                                                                                            <td colspan="3"><div align="center"><a href="controler?/san/jmat/perpus/action=peminjamanBuku"><font color="red">All Buku</font></a></div></td>
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
                                        <td valign="top" width="550"><br />
                                            <table width="398" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="463"> <font color="yellow"><font style="color: yellow;" size="+1"><span style="font-family: Nimbus Sans L; font-size: 24px;">PERPUSTAKAAN
                                                                        SMART</span><br />
                                                                </font></font>
                                                            <div style="text-align: left; color: #FF0; font-size: 18px;">
                                                                <form id="form2" name="form2" method="post" action="controler?/san/jmat/perpus/action=peminjamanBukuFinish">
                                                                    <san:if test="${keranjangFull==null}"><p>Jumlah Buku Yang Hendak Dipinjam = ${itemKeranjang}          , <a href="controler?/san/jmat/perpus/action=lihatIsiKeranjang"><font color="yellow">View</font></a>
                                                                            &nbsp;<a href="controler?/san/jmat/perpus/action=resetKeranjang"><font color="red">RESET</font></a></p></san:if>
                                                                    <san:if test="${keranjangFull!=null}">
                                                                        <p> Maksimal Peminjaman 3 Buku &nbsp;<a href="controler?/san/jmat/perpus/action=resetKeranjang"><font color="red">RESET</font></a>
                                                                        </p></san:if>
                                                                        <div align="left">
                                                                            <table width="351" border="0">
                                                                                <san:if test="${msg!=null}">
                                                                                <tr>
                                                                                    <td colspan="3"><div align="center"><font color="red">${msg}</font></div></td>
                                                                                </tr>
                                                                                </san:if>
                                                                                <tr>
                                                                                    <td width="142">Nomor Anggota</td>
                                                                                    <td width="10"><div align="center">:</div></td>
                                                                                    <td width="185"><label for="nomorAnggota"></label>
                                                                                        <input name="nomorAnggota" type="text" id="nomorAnggota" size="30" maxlength="30" /></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Tanggal Pinjam</td>
                                                                                    <td><div align="center">:</div></td>
                                                                                    <td><label for="dd"></label>
                                                                                        <input name="dd" type="text" id="dd" size="5" maxlength="2" align="center" value="${tgl}"/> 
                                                                                        -
                                                                                        <label for=""></label>
                                                                                        <input name="MM" type="text" id="MM" size="5" maxlength="2" align="center" value="${bln}"/>
                                                                                        -
                                                                                        <label for="yyyy"></label>
                                                                                        <input name="yyyy" type="text" id="yyyy" size="8" maxlength="4" align="center" value="${thn}"/></td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                <san:if test="${keranjangFull==null}"><td><input type="submit" name="button2" id="button2" value="Pinjam" /></td></san:if>
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