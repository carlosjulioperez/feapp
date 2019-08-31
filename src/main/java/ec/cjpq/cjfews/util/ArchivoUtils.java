package ec.cjpq.cjfews.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ec.cjpq.fe.util.Util;

public class ArchivoUtils {

	private static Logger log = LogManager.getLogger(ArchivoUtils.class);

	public static File stringToArchivo(String rutaArchivo, String contenidoArchivo) {
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
            log.warn(Util.stack2String(ex));
			return null;
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception ex) {
                log.warn(Util.stack2String(ex));
			}
		}
	}

}
