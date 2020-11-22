import random
import copy
import pprint
import math

COORDINATE_SYSTEM_LIMITS = 1000


class State:
    def __init__(self, route: [], distance: int = 0):
        self.route = route
        self.distance = distance

    def __eq__(self, other):
        for i in range(len(self.route)):
            if(self.route[i] != other.route[i]):
                return False
        return True

    def __lt__(self, other):
        return self.distance < other.distance

    def __repr__(self):
        return ('({0},{1})\n'.format(self.route, self.distance))

    def copy(self):
        return State(self.route, self.distance)

    def deepcopy(self):
        return State(copy.deepcopy(self.route), copy.deepcopy(self.distance))

    def update_distance(self, matrix, start_point):
        self.distance = 0

        from_index = start_point

        for i in range(len(self.route)):
            self.distance += matrix[from_index][self.route[i]]
            from_index = self.route[i]
            
        self.distance += matrix[from_index][start_point]


class Point:
    def __init__(self, index: int, distance: int):
        self.index = index
        self.distance = distance

    def __lt__(self, other):
        return self.distance < other.distance


def create_population(dist_matrix, start_point: int, point_indexes: [], generations: int):
    gene_pool = point_indexes.copy()

    gene_pool.pop(start_point)

    population = []
    for i in range(generations):
        random.shuffle(gene_pool)

        state = State(gene_pool[:])
        state.update_distance(dist_matrix, start_point)

        population.append(state)

    return population


def crossover(dist_matrix: [], start_point: int, parents: []):
    parent_1 = parents[0].deepcopy()
    parent_2 = parents[1].deepcopy()

    # the different parts of the child genes
    part_1 = []
    part_2 = []

    # which genes to get from the parents
    a = int(random.random() * len(parent_1.route))
    b = int(random.random() * len(parent_2.route))
    start_gene = min(a, b)
    end_gene = max(a, b)

    # genes from the first parent
    for i in range(start_gene, end_gene):
        part_1.append(parent_1.route[i])

    # genes from the second parent
    part_2 = [int(x) for x in parent_2.route if x not in part_1]

    state = State(part_1 + part_2)
    state.update_distance(dist_matrix, start_point)

    return state


def mutate(dist_matrix: [], start_point: int, state: State, mutation_rate: float = 0.01):
    mutated_state = state.deepcopy()

    # go though all of the states
    for i in range(len(mutated_state.route)):

        # if we should mutate
        if(random.random() < mutation_rate):

            # swap two points
            j = int(random.random() * len(state.route))
            city_1 = mutated_state.route[i]
            city_2 = mutated_state.route[j]
            mutated_state.route[i] = city_2
            mutated_state.route[j] = city_1

    mutated_state.update_distance(dist_matrix, start_point)

    return mutated_state


def genetic_algorithm(dist_matrix: [], start_point: int, steps_to_print_length: [], population: [], keep: int, mutation_rate: float, generations: int):
    for i in range(generations):

        # we want the fittest individuals to be first
        population.sort()

        # check if we should print the best dist at a given generation step
        if steps_to_print_length and steps_to_print_length[-1] == i:
            print(f'Fittest individual at step {steps_to_print_length[-1]}: {population[0].distance}')
            steps_to_print_length.pop()

        # create parents
        parents = []
        for j in range(1, len(population)):
            parents.append((population[j-1], population[j]))

        # create children with crossover
        children = []
        for partners in parents:
            children.append(crossover(dist_matrix, start_point, partners))

        # mutate children
        for j in range(len(children)):
            children[j] = mutate(dist_matrix, start_point, children[j], mutation_rate)

        # keep the fittest n from the population
        population = population[:keep]

        population.extend(children)

    population.sort()

    return population[0]


def distance_between_two_points(p1, p2):
    return int(math.dist(p1, p2))


def init_distance_matrix(number_of_points, points):
    dist_matrix = []

    for i in range(number_of_points):
        row = []
        for j in range(number_of_points):
            row.append(distance_between_two_points(points[i], points[j]))
        dist_matrix.append(row)

    return dist_matrix


def main():
    n = int(input('Enter the number of points <= 100: '))

    # Random points
    point_indexes = [i for i in range(n)]
    points = [(random.randint(-COORDINATE_SYSTEM_LIMITS, COORDINATE_SYSTEM_LIMITS), 
               random.randint(-COORDINATE_SYSTEM_LIMITS, COORDINATE_SYSTEM_LIMITS)) for _ in range(n)]

    # Calculate distances between the points
    dist_matrix = init_distance_matrix(n, points)

    # Genetic algorithm parameters
    start = random.randint(0, n - 1)
    generations = 100
    mutation_rate = 0.01
    keep = 10

    between_steps = generations // 4
    steps_to_print_length = [i for i in range(generations, 10, -between_steps)]
    steps_to_print_length.append(10)

    population = create_population(dist_matrix, start, point_indexes, generations)
    state = genetic_algorithm(dist_matrix, start, steps_to_print_length, population, keep, mutation_rate, generations)

    print(f'Fittest individual on step {generations}: ', state.distance)


if __name__ == "__main__":
    main()
