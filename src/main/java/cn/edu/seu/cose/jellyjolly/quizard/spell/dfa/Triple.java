/*
 * The MIT License
 *
 * Copyright 2013 Jelly Jolly Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cn.edu.seu.cose.jellyjolly.quizard.spell.dfa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class Triple<Key1, Key2, Value> {

    private Map<Key1, Map<Key2, Value>> map;

    public Triple() {
        map = new HashMap<Key1, Map<Key2, Value>>();
    }

    public Value get(Key1 key1, Key2 key2) {
        Map<Key2, Value> subMap = map.get(key1);
        return (subMap == null) ? null : subMap.get(key2);
    }

    public Value put(Key1 key1, Key2 key2, Value value) {
        Map<Key2, Value> subMap = map.get(key1);
        if (subMap == null) {
            subMap = new HashMap<Key2, Value>();
        }
        return subMap.put(key2, value);
    }

    public boolean containsKey(Key1 key1, Key2 key2) {
        if (!map.containsKey(key1)) {
            return false;
        }
        Map<Key2, Value> subMap = map.get(key1);
        return subMap.containsKey(key2);
    }

    public Map<Key2, Value> remove(Key1 key1) {
        return map.remove(key1);
    }

    public Value remove(Key1 key1, Key2 key2) {
        if (!map.containsKey(key1)) {
            return null;
        }
        Map<Key2, Value> subMap = map.get(key1);
        return subMap.remove(key2);
    }

    public void clear() {
        map.clear();
    }
}
