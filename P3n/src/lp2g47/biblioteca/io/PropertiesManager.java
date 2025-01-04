package lp2g47.biblioteca.io;

import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;
import lp2g47.biblioteca.selector.Selector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public final class PropertiesManager {

    private static File PROPERTIES_FILE = null;
    private static String PROPERTIES_PATH = null;
    private static String[] PROPERTIES_KEYS = null;
    private static Type[] PROPERTIES_TYPES = null;
    private static Properties properties = null;

    public static void setProperties(String PROPERTIES_PATH, String[] PROPERTIES_KEYS, Type[] PROPERTIES_TYPES) {
        if (PROPERTIES_KEYS.length != PROPERTIES_TYPES.length) {
            throw new IllegalArgumentException("Número de chaves e tipos de propriedades não correspondem.");
        }
        PropertiesManager.PROPERTIES_PATH = PROPERTIES_PATH;
        PropertiesManager.PROPERTIES_KEYS = PROPERTIES_KEYS;
        PropertiesManager.PROPERTIES_TYPES = PROPERTIES_TYPES;
    }

    public static String getPropertiesName() {
        if (PROPERTIES_FILE == null) {
            return null;
        }
        return PROPERTIES_FILE.getName().replace(".properties", "");
    }

    public static void propertiesMenu() throws Return, ExitApplication {
        String[] options = {
                "Carregar arquivo de propriedades",
                "Criar novo arquivo de propriedades",
                "Alterar propriedades",
                "Deletar arquivo de propriedades",
                "Visualizar propriedades",
                "Retornar"
        };
        Integer[] optionsNumbers = new Integer[options.length];
        for (int i = 0; i < options.length; i++) {
            optionsNumbers[i] = i + 1;
        }
        Selector<Integer> selector = new Selector<>(
                optionsNumbers,
                options,
                "Menu de propriedades",
                "Digite o número da opção desejada: "
        );
        Integer option = selector.select();
        switch (option) {
            case 1:
                try {
                    selectProperties();
                    DataManager.verifyData();
                } catch (IOException e) {
                    System.out.println("Falha ao carregar arquivo de propriedades: " + e.getMessage());
                    propertiesMenu();
                } catch (Return e) {
                    System.out.println(e.getMessage());
                    propertiesMenu();
                }
                propertiesMenu();
                break;
            case 2:
                try {
                    createProperties();
                    DataManager.createData();
                } catch (IOException e) {
                    System.out.println("Falha ao criar arquivo de propriedades: " + e.getMessage());
                    propertiesMenu();
                } catch (Return e) {
                    System.out.println(e.getMessage());
                    propertiesMenu();
                }
                propertiesMenu();
                break;
            case 3:
                try {
                    updateProperties();
                    DataManager.verifyData();
                } catch (IOException e) {
                    System.out.println("Falha ao alterar propriedades: " + e.getMessage());
                    propertiesMenu();
                } catch (Return e) {
                    System.out.println(e.getMessage());
                    propertiesMenu();
                }
                propertiesMenu();
                break;
            case 4:
                try {
                    deleteProperties();
                } catch (IOException e) {
                    System.out.println("Falha ao deletar arquivo de propriedades: " + e.getMessage());
                    propertiesMenu();
                } catch (Return e) {
                    System.out.println(e.getMessage());
                    propertiesMenu();
                }
                propertiesMenu();
                break;
            case 5:
                try {
                    printProperties();
                } catch (Return e) {
                    System.out.println(e.getMessage());
                    propertiesMenu();
                }
                propertiesMenu();
                break;
            case 6:
                throw new Return("Retornando ao menu principal...");
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            return null;
        }
        return properties.getProperty(key);
    }

    private static void selectProperties() throws IOException, ExitApplication, Return {
        PROPERTIES_FILE = FileManager.getFolderFile(PROPERTIES_PATH, "Selecione o arquivo de propriedades", "Digite o número do arquivo: ");
        loadProperties();
    }

    private static void createProperties() throws IOException, ExitApplication, Return {
        File newFile = new File(PROPERTIES_PATH + "/" + Input.get("Digite o nome do arquivo de propriedades: ") + ".properties");
        if (newFile.exists()) {
            throw new Return("Arquivo de propriedades já existe, selecione outro nome ou delete o arquivo existente.");
        }
        PROPERTIES_FILE = newFile;
        try {
            generateProperties();
        } catch (Return e) {
            System.out.println(e.getMessage());
            createProperties();
        }
        saveProperties();
    }

    private static void loadProperties() throws IOException {
        FileInputStream propFile = new FileInputStream(PROPERTIES_FILE);
        Properties localProperties = new Properties();
        localProperties.load(propFile);

        Set<String> propKeys = localProperties.stringPropertyNames();
        Set<String> localKeys = new HashSet<>(propKeys);

        for (String key : propKeys) {
            if (!localKeys.contains(key)) {
                throw new IOException("Arquivo de propriedades inválido: propriedade '" + key + "' não é uma propriedade válida.");
            }
        }

        for (String key : localKeys) {
            if (!propKeys.contains(key)) {
                throw new IOException("Arquivo de propriedades inválido: propriedade '" + key + "' não encontrada.");
            }
        }

        properties = localProperties;
        System.out.println("Arquivo '" + PROPERTIES_FILE.getName() + "' carregado com sucesso.");
    }

    public static void saveProperties() throws IOException {
        System.out.println("Salvando arquivo de propriedades...");
        if (properties == null || PROPERTIES_FILE == null) {
            throw new IOException("Nenhum arquivo de propriedades carregado.");
        }
        if (!PROPERTIES_FILE.getParentFile().exists()) {
            PROPERTIES_FILE.getParentFile().mkdirs();
        }
        FileOutputStream file = new FileOutputStream(PROPERTIES_FILE);
        properties.store(file, PROPERTIES_FILE.getName());
        System.out.println("Arquivo '" + PROPERTIES_FILE.getName() + "' salvo com sucesso.");
    }

    private static void generateProperties() throws ExitApplication, Return {
        Properties newProperties = new Properties();
        for (int i = 0; i < PROPERTIES_KEYS.length; i++) {
            String value = getPropertyValue(PROPERTIES_KEYS[i], PROPERTIES_TYPES[i]);
            newProperties.setProperty(PROPERTIES_KEYS[i], value);
        }
        properties = newProperties;
    }

    private static String getPropertyValue(String key, Type type) throws Return, ExitApplication {
        String value = Input.get("Digite o valor de '" + key + "' (" + type.getTypeName().replace("java.lang.", "") + "): ");
        if (type.equals(Double.class)) {
            try {
                Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.println("O valor informado não é um número decimal.");
                return getPropertyValue(key, type);
            }
        } else if (type.equals(Integer.class)) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("O valor informado não é um número inteiro.");
                return getPropertyValue(key, type);
            }
        }
        return value;
    }

    private static void updateProperties() throws ExitApplication, Return, IOException {
        if (properties == null || PROPERTIES_FILE == null) {
            throw new Return("Nenhum arquivo de propriedades carregado.");
        }
        updateProperty();
        String option = Input.getOption("Deseja alterar outra propriedade? (s/n): ");
        if (option.equals("s")) {
            updateProperties();
        }
    }

    private static void updateProperty() throws ExitApplication, Return, IOException {
        String[] propKeysDescriptions = new String[PROPERTIES_KEYS.length];
        for (int i = 0; i < PROPERTIES_KEYS.length; i++) {
            propKeysDescriptions[i] = PROPERTIES_KEYS[i] + " = " + properties.getProperty(PROPERTIES_KEYS[i]);
        }
        Selector<String> selector = new Selector<>(
                PROPERTIES_KEYS,
                propKeysDescriptions,
                "Selecione a propriedade que deseja alterar do arquivo " + PROPERTIES_FILE.getName(),
                "Digite o número da propriedade: "
        );
        String key = selector.select();
        String value = Input.get("Digite o novo valor de '" + key + "': ");
        properties.replace(key, value);
        saveProperties();
    }

    private static void deleteProperties() throws ExitApplication, Return, IOException {
        String option = Input.getOption("A deleção do arquivo de propriedades é irreversível e " +
                "irá apagar todos os dados relacionados a ele. Deseja continuar? (s/n): ");
        if (option.equals("s")) {
            try {
                if (PROPERTIES_FILE.delete()) {
                    System.out.println("Arquivo '" + PROPERTIES_FILE.getName() + "' deletado com sucesso.");
                } else {
                    throw new IOException("Falha ao deletar arquivo: " + PROPERTIES_FILE.getName());
                }
            } finally {
                DataManager.deleteData();
                properties = null;
                PROPERTIES_FILE = null;
            }
        }
    }

    private static void printProperties() throws Return {
        if (properties == null || PROPERTIES_FILE == null) {
            throw new Return("Nenhum arquivo de propriedades carregado.");
        } else {
            String line = String.format("%0" + 40 + "d", 0).replace("0", "-");
            System.out.println(line);
            System.out.println("Propriedades do arquivo " + PROPERTIES_FILE.getName());
            System.out.println(line);
            for (String key : PROPERTIES_KEYS) {
                System.out.println(key + " = " + properties.getProperty(key));
            }
            System.out.println(line);
        }
    }
}
