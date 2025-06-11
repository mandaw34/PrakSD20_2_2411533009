package Pekan8;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class MergeSortGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array;
	private int[] temp;
	private int left, mid, right, i, j, k;
	private boolean isMerging = false;
	private boolean copying = false;

	private JLabel[] labelArray;
	private JButton stepButton, resetButton, setButton;
	private JTextField inputfield;
	private JPanel panelArray;
	private JTextArea stepArea;
	private Queue<int[]> mergeQueue = new LinkedList<>();

	private int stepCount;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MergeSortGUI frame = new MergeSortGUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MergeSortGUI() {
		setTitle("Merge Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel(new FlowLayout());
		inputfield = new JTextField(30);
		setButton = new JButton("Set Array");
		inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma) : "));
		inputPanel.add(inputfield);
		inputPanel.add(setButton);

		panelArray = new JPanel();
		panelArray.setLayout(new FlowLayout());

		JPanel controlPanel = new JPanel();
		stepButton = new JButton("Langkah Selanjutnya");
		resetButton = new JButton("Reset");
		stepButton.setEnabled(false);
		controlPanel.add(stepButton);
		controlPanel.add(resetButton);

		stepArea = new JTextArea(8, 60);
		stepArea.setEditable(false);
		stepArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(stepArea);

		add(inputPanel, BorderLayout.NORTH);
		add(panelArray, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.EAST);

		// Tambahkan event listener
		setButton.addActionListener(e -> setArrayFromInput());
		stepButton.addActionListener(e -> performStep());
		resetButton.addActionListener(e -> reset());
	}

	private void setArrayFromInput() {
		String text = inputfield.getText().trim();
		if (text.isEmpty()) return;
		String[] parts = text.split(",");
		array = new int[parts.length];
		try {
			for (int i = 0; i < parts.length; i++) {
				array[i] = Integer.parseInt(parts[i].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		labelArray = new JLabel[array.length];
		panelArray.removeAll();
		for (int i = 0; i < array.length; i++) {
			labelArray[i] = new JLabel(String.valueOf(array[i]));
			labelArray[i].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray[i].setOpaque(true);
			labelArray[i].setBackground(Color.WHITE);
			labelArray[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray[i].setPreferredSize(new Dimension(50, 50));
			labelArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray.add(labelArray[i]);
		}
		mergeQueue.clear();
		generateMergeStep(0, array.length - 1);
		stepButton.setEnabled(true);
		stepArea.setText("");
		stepCount = 1;
		isMerging = false;
		copying = false;
		panelArray.revalidate();
		panelArray.repaint();
	}

	private void performStep() {
		resetHighlights();

		if (!isMerging && !mergeQueue.isEmpty()) {
			int[] range = mergeQueue.poll();
			left = range[0];
			mid = range[1];
			right = range[2];
			temp = new int[right - left + 1];
			i = left;
			j = mid + 1;
			k = 0;
			isMerging = true;
			stepArea.append("Langkah " + stepCount++ + ": Bandingkan dan salin elemen \n");
			return;
		}

		if (isMerging) {
			if (i <= mid && j <= right) {
				labelArray[i].setBackground(Color.CYAN);
				labelArray[j].setBackground(Color.CYAN);
				if (array[i] <= array[j]) {
					temp[k++] = array[i++];
				} else {
					temp[k++] = array[j++];
				}
				stepArea.append("Langkah " + stepCount++ + ": Bandingkan dan salin elemen \n");
				return;
			} else if (i <= mid) {
				temp[k++] = array[i++];
				stepArea.append("Langkah " + stepCount++ + ": Salin sisa kiri\n");
				return;
			} else if (j <= right) {
				temp[k++] = array[j++];
				stepArea.append("Langkah " + stepCount++ + ": Salin sisa kanan\n");
				return;
			} else {
				copying = true;
				k = 0;
			}
		}

		if (copying && k < temp.length) {
			array[left + k] = temp[k];
			labelArray[left + k].setText(String.valueOf(temp[k]));
			labelArray[left + k].setBackground(Color.GREEN);
			k++;
			stepArea.append("Langkah " + stepCount++ + ": Tempelkan ke array utama \n");
			return;
		}

		if (copying && k == temp.length) {
			isMerging = false;
			copying = false;
		}

		if (mergeQueue.isEmpty() && !isMerging) {
			stepArea.append("Selesai.\n");
			stepButton.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
		}
	}

	private void resetHighlights() {
		if (labelArray == null) return;
		for (JLabel label : labelArray) {
			label.setBackground(Color.WHITE);
		}
	}

	private void reset() {
		inputfield.setText("");
		panelArray.removeAll();
		panelArray.revalidate();
		panelArray.repaint();
		stepArea.setText("");
		stepButton.setEnabled(false);
		stepCount = 1;
		isMerging = false;
		copying = false;
	}

	private void generateMergeStep(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			generateMergeStep(left, mid);
			generateMergeStep(mid + 1, right);
			mergeQueue.add(new int[]{left, mid, right});
		}
	}
}
