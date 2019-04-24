package ec.cjpq.cjfews.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoUtils {

	public static File stringToArchivo(String rutaArchivo,
			String contenidoArchivo) {
		FileOutputStream fos = null;
		File archivoCreado = null;
		try {
			fos = new FileOutputStream(rutaArchivo);
			OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
			for (int i = 0; i < contenidoArchivo.length(); i++) {
				out.write(contenidoArchivo.charAt(i));
			}
			out.close();

			return new File(rutaArchivo);
		} catch (Exception ex) {
			Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception ex) {
				Logger.getLogger(ArchivoUtils.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

}
