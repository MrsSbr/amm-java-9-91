import tools.MeasuringTool;
import tools.MetalCuttingTool;
import tools.MillingСutters;
import tools.TapeMeasure;
import tools.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToolTest {
    public static void main(String[] args) {
        List<Tool> tools = new ArrayList<Tool>();
        tools.add(new MillingСutters(0.5,20, 10));
        tools.add(new TapeMeasure(0.3,0.1, 5.0));
        tools.add(new TapeMeasure(0.2,0.05, 3.0));
        tools.add(new MillingСutters(0.6,10, 15));

        System.out.println("Информация о всех металлорежущих инструментах:");
        List<Tool> metalCuttingTools = getAllMetalCuttingTool(tools);
        System.out.println(getInfoAboutAllTools(metalCuttingTools));
        List<Tool> measuringTools = getAllMeasuringTool(tools);
        System.out.println("Работа всех измерительных инструментов:");
        workAllTools(measuringTools);
    }

    public static List<Tool> getAllMeasuringTool(List<Tool> tools){
        return tools.stream()
                .filter(tool -> tool instanceof MeasuringTool)
                .toList();
    }
    public static List<Tool> getAllMetalCuttingTool(List<Tool> tools){
        return tools.stream()
                .filter(tool -> tool instanceof MetalCuttingTool)
                .toList();
    }
    public static void workAllTools(List<Tool> tools) {
        tools.forEach(Tool::work);
    }
    public static String getInfoAboutAllTools(List<Tool> tools) {
        return tools.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
