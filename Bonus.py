class DPDA:
    def __init__(self, states, input_symbols, stack_symbols, transitions, start_state, start_stack_symbol, accept_states):
        self.states = states
        self.input_symbols = input_symbols
        self.stack_symbols = stack_symbols
        self.transitions = transitions
        self.start_state = start_state
        self.start_stack_symbol = start_stack_symbol
        self.accept_states = accept_states

    def accept(self, input_string):
        stack = [self.start_stack_symbol]
        current_state = self.start_state

        for symbol in input_string:
            if (current_state, symbol, stack[-1]) not in self.transitions:
                return False
            else:
                new_state, new_stack_top = self.transitions[(current_state, symbol, stack[-1])]
                current_state = new_state
                if new_stack_top != '':
                    stack.pop()
                    stack.extend(new_stack_top[::-1])  

        return current_state in self.accept_states and len(stack) == 1

states = {'q0', 'q1', 'q2'}
input_symbols = {'a', 'b'}
stack_symbols = {'X', 'Y'}
transitions = {
    ('q0', 'a', 'X'): ('q1', 'XY'),
    ('q1', 'a', 'Y'): ('q1', 'YY'),
    ('q1', 'b', 'Y'): ('q2', ''),
}
start_state = 'q0'
start_stack_symbol = 'X'
accept_states = {'q2'}

dpda = DPDA(states, input_symbols, stack_symbols, transitions, start_state, start_stack_symbol, accept_states)
print(dpda.accept('aab')) 

class NPDA:
    def __init__(self, states, input_symbols, stack_symbols, transitions, start_state, start_stack_symbol, accept_states):
        self.states = states
        self.input_symbols = input_symbols
        self.stack_symbols = stack_symbols
        self.transitions = transitions
        self.start_state = start_state
        self.start_stack_symbol = start_stack_symbol
        self.accept_states = accept_states

    def epsilon_closure(self, states):
        closure = set(states)
        stack = list(states)
        while stack:
            state = stack.pop()
            if ('', state, '') in self.transitions:
                for s in self.transitions[('', state, '')]:
                    if s not in closure:
                        closure.add(s)
                        stack.append(s)
        return closure

    def accept(self, input_string):
        current_states = self.epsilon_closure({self.start_state})
        stack = [self.start_stack_symbol]

        for symbol in input_string:
            next_states = set()
            for state in current_states:
                if (state, symbol, stack[-1]) in self.transitions:
                    next_states.update(self.transitions[(state, symbol, stack[-1])])

            current_states = self.epsilon_closure(next_states)

        return any(state in self.accept_states for state in current_states)

states = {'q0', 'q1', 'q2'}
input_symbols = {'a', 'b'}
stack_symbols = {'X', 'Y'}
transitions = {
    ('q0', 'a', 'X'): {'q1'},
    ('q1', 'a', 'Y'): {'q1'},
    ('q1', 'b', 'Y'): {'q2'},
}
start_state = 'q0'
start_stack_symbol = 'X'
accept_states = {'q2'}

npda = NPDA(states, input_symbols, stack_symbols, transitions, start_state, start_stack_symbol, accept_states)
print(npda.accept('aab')) 
