package collections.hashtables;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SimpHashTable<K, V> implements Map<K, V> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(final Object key) {
        return false;
    }

    @Override
    public boolean containsValue(final Object value) {
        return false;
    }

    @Override
    public V get(final Object key) {
        return null;
    }

    @Override
    public V put(final K key, final V value) {
        return null;
    }

    @Override
    public V remove(final Object key) {
        return null;
    }

    @Override
    public void putAll(final Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
