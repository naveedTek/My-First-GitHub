package zee.project.main.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	
	private static ReadYamlFiles readYamlFiles;
	private HashMap PropertyMap;
	
	
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = UtilityFile.getFileInputStream(filePath);
		Yaml yaml = new Yaml();
		this.PropertyMap = yaml.load(fileInputStream);
	}
	
	
	
	public static ReadYamlFiles getYamlInstance(String filePath) throws FileNotFoundException {
		if(readYamlFiles == null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;
	}
	
	
	
	
	public HashMap getYamlProperty(String key) {
		return(HashMap)this.PropertyMap.get(key);
	}
	
	
	
	
	
	
	

}
