package ar.edu.unlam.tallerweb1.delivery;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;

import ar.edu.unlam.tallerweb1.domain.Entrada;
import ar.edu.unlam.tallerweb1.domain.EntradaService;
import ar.edu.unlam.tallerweb1.domain.QRCodeGenerator;

@Controller
public class EntradaController {
	
	private EntradaService servicioEntrada;
	private Long id;
	
	@Autowired
	public EntradaController(EntradaService entradaService) {
		this.servicioEntrada = entradaService;
	}
	/*
	@RequestMapping(path = "entrada-qr", method = RequestMethod.GET)
    public ModelAndView generarQr(@PathVariable("id") Long id) {
        // Aquí debes incluir el código para obtener el objeto Entrada según su ID
        ModelMap model = new ModelMap();
        
		Entrada entrada = obtenerEntradaPorId(id);
        
        // Generar el código QR para la entrada
        String qrCodeText = "https://www.example.com/entrada/" + entrada.getId();
        int qrCodeSize = 300;
        try {
            BufferedImage qrCodeImage = QRCodeGenerator.generateQRCodeImage(qrCodeText, qrCodeSize);
            byte[] qrCodeBytes = QRCodeGenerator.convertImageToByteArray(qrCodeImage, "png");
            String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeBytes);

            model.put("qrCodeBase64", qrCodeBase64);
        } catch (WriterException | IOException e) {
            // Manejar la excepción en caso de error
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView("entrada-qr", model); 
        return mav; // Nombre del JSP para mostrar el código QR
    }

    // Método para obtener la entrada por su ID (debes implementarlo según tu lógica)
    private Entrada obtenerEntradaPorId(Long id) {
        return servicioEntrada.buscarPorId(id);
    }
    */

}
