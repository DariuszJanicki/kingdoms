package utils.datastructure;

import utils.Opt;
import utils.points.Coords;
import utils.points.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class GameArray<T> implements Collection<T> {

    private List<List<T>> array;
    private Size size;

    /* ========== PUBLIC ========== */
    public GameArray(Size size, ObjFactory<T> factory) {
        this.size = size;
        createTiles(factory);
    }

    public Opt<T> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? array.get(coords.getX()).get(coords.getY())
                : null);
    }

    /* ========== PRIVATE ========== */
    private void createTiles(ObjFactory<T> factory) {
        array = new ArrayList<>(size.getX());
        for (int i = 0; i <= size.getX(); ++i) {
            array.add(i, new ArrayList<>(size.getY()));
            for (int j = 0; j <= size.getY(); ++j) {
                array.get(i).add(j, factory.create(new Coords(i, j)));
            }
        }
    }

    @Override
    public int size() {
        return size.getX() * size.getY();
    }

    @Override
    public boolean isEmpty() {
        return array.stream().allMatch(List::isEmpty);
    }

    @Override
    public boolean contains(Object o) {
        return array.stream().anyMatch(list -> list.contains(o));
    }

    @Override
    public Iterator<T> iterator() {
        // TODO djanicki implement me
        return array.get(0).iterator();
    }

    @Override
    public Object[] toArray() {
        // TODO djanicki implement me
        return array.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // TODO djanicki implement me
        return array.toArray(a);
    }

    @Override
    public boolean add(T t) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public void clear() {
        // TODO djanicki implement me

    }

    @Override
    public boolean equals(Object o) {
        // TODO djanicki implement me
        return false;
    }

    @Override
    public int hashCode() {
        // TODO djanicki implement me
        return 0;
    }
}
