package Class;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public void saveObj() {
	JFileChooser jfc = new JFileChooser();
	if(jfc.showDialog(jfc, null)==JFileChooser.APPROVE_OPTION) {
		File file = jfc.getSelectedFile();
		try {
			ObjectOutputStream oout = new ObjectOutputStream();
			JOptionPane.showMessageDialog(null, "Save success!!!");
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "存檔失敗");
		}
		
	}
}

public int[] getSnakeCoori() {
	int[] coo = {snakeX, snakeY};
	return coo;
}
