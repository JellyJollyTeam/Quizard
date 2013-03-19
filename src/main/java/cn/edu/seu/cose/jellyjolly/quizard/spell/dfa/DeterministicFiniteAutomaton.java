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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class DeterministicFiniteAutomaton {

    private final Triple<Integer, Character, Integer> transitionTable;
    private Set<Integer> endStates;

    public DeterministicFiniteAutomaton() {
        transitionTable = new Triple<Integer, Character, Integer>();
        endStates = new HashSet<Integer>();
    }

    public DeterministicFiniteAutomaton(
            Triple<Integer, Character, Integer> transitionTable,
            int[] endStates) {
        this.transitionTable = transitionTable;
        this.endStates = new HashSet<Integer>();
        for (int endState : endStates) {
            this.endStates.add(endState);
        }
    }

    public void defineTransition(int fromState, int toState,
            char[] conditions) {
        transitionTable.put(fromState, Character.MIN_VALUE, toState);
    }

    public void addEndState(int endState) {
        endStates.add(endState);
    }

    public void addAllEndStates(Collection<Integer> endStates) {
        this.endStates.addAll(endStates);
    }

    public int run(final CharSequence charSeq) throws DFAException {
        return run(charSeq, 0);
    }

    public int run(final CharSequence charSeq, int startIndex)
            throws DFAException {
        int currentState = 0;
        int seqIndex = startIndex;
        while (true) {
            boolean isOutOfBounds = seqIndex >= charSeq.length();
            if (isOutOfBounds) {
                throw new IncompleteSequenceException(currentState);
            }
            boolean isLastIndex  = seqIndex == (charSeq.length() - 1);
            boolean isOnEndState = endStates.contains(currentState);
            if (isLastIndex && isOnEndState) {
                break;
            }

            // transit
            char currentChar = charSeq.charAt(seqIndex);
            if (!transitionTable.containsKey(currentState, currentChar)) {
                throw new DFAException();
            }
            int nextState = transitionTable.get(currentState, currentChar);

            // go to next step
            currentState = nextState;
            ++seqIndex;
        }
        return seqIndex;
    }
}
