import com.sun.management.OperatingSystemMXBean;
import java.awt.*;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class CpuDashboard {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CpuDashboard::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cuadro de Mando - Uso de CPU y Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        JLabel cpuLabel = new JLabel("Uso de CPU: Calculando...", SwingConstants.CENTER);
        cpuLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(cpuLabel);
        
        JLabel memoryLabel = new JLabel("Memoria: Calculando...", SwingConstants.CENTER);
        memoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(memoryLabel);
        
        JLabel diskLabel = new JLabel("Espacio en Disco: Calculando...", SwingConstants.CENTER);
        diskLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(diskLabel);

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                double cpuLoad = getCpuLoad();
                long[] memory = getMemoryUsage();
                long[] disk = getDiskUsage();
                SwingUtilities.invokeLater(() -> {
                    cpuLabel.setText(String.format("Uso de CPU: %.2f%%", cpuLoad * 100));
                    memoryLabel.setText(String.format("Memoria Ocupada: %.2f GB, Libre: %.2f GB", memory[0] / 1e9, memory[1] / 1e9));
                    diskLabel.setText(String.format("Disco Ocupado: %.2f GB, Libre: %.2f GB", disk[0] / 1e9, disk[1] / 1e9));
                });
            }
        }, 0, 1000);

        frame.setVisible(true);
    }

    private static double getCpuLoad() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return osBean.getCpuLoad();
    }
    
    private static long[] getMemoryUsage() {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory - freeMemory;
        return new long[]{usedMemory, freeMemory};
    }
    
    private static long[] getDiskUsage() {
        File root = new File("/");
        long totalSpace = root.getTotalSpace();
        long freeSpace = root.getFreeSpace();
        long usedSpace = totalSpace - freeSpace;
        return new long[]{usedSpace, freeSpace};
    }
}
