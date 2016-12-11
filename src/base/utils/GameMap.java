package base.utils;

import utils.Opt;

import java.util.HashMap;
import java.util.Map;

public class GameMap<K, V> {

    private Map<K, V> map = new HashMap<K, V>();

    public void putAll(K key, V value) {
        map.put(key, value);
    }

    public Opt<V> get(K key) {
        return Opt.ofNullable(map.get(key));
    }

    public Opt<V> get(Opt<K> key) {
        return key.isPresent().isTrue() ? Opt.ofNullable(map.get(key.get())) : Opt.empty();
    }

    public void putAll(GameMap<K, V> otherMap) {
        map.putAll(otherMap.map);
    }
}
