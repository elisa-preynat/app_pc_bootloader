package app_pc_bootloader.app_pc_bootloader;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppPcBootloaderApplication {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Application Bootloader");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton downloadBtn = new JButton("Télécharger le .bin");
	
		
		downloadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try (FileInputStream pathFile = new FileInputStream("D:\\Documents\\testtelechargement.bin")) {
					ReadableByteChannel readableByteChannel = Channels.newChannel(pathFile);

					try (FileOutputStream fos = new FileOutputStream(
							"D:\\Documents\\Téléchargements\\Test_Telechargement\\testtelechargementDOWN.bin")) {
						fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
						System.out.println("Le fichier .bin se trouve dans votre dossier téléchargement.");
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		);
		frame.add(downloadBtn);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 300);
	}

}