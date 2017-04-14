TwoDimMap is library for representation and storing two dimensional maps of finite size. Map can represent different types of information. For example black&white mask, heightmap, RGB image.

## Features
	- Data layers
	- Storing and loading: images, ascii images
	- Map transformations
	- Generic typed classes  allows for different implementations for storing data

## Usage
### Working with boolean layer (mask):

```
MapLayer maskLayer = new BooleanMapLayer(10, 21); // width, height

maskLayer.set(3, 5, true); // x, y, value

maskLayer.get(3, 5) // x, y = true
```

### Reading and writing
```
GeneralMapReader reader = new GeneralMapReader();
GeneralMapWriter writer = new GeneralMapWriter();

MapLayer heightmap = reader.read(new File("in.png"));
heightmap.set(0, 0, 0.42f);
writer.write(heightmap, new File("out.png"));
```

### Combining layers
Layers can be combined together to create new maps. There are several modes of combining.
```
MapLayer terrain = new GeneralMapLayer();

MapLayer roads = new BooleanMapLayer(20, 20);

CombineMapLayer combined = new CombinedMapLayer(CombineMode.ADD);

combined.addLayer(terrain);
combined.addLayer(roads);

combined.get(0, 0); //returns combined value using chosen mode
```

### CombineMode list
NORMAL (default) - Uses first non black color occurred
AVG - Average of layers
MIN - Darkest color
MAX - Lightest color