import random
import copy
import math

COORDINATE_SYSTEM_LIMITS = 1000


class State:
    def __init__(self, route, distance=0):
        self.route = route
        self.distance = distance

    def __lt__(self, other):
        return self.distance < other.distance

    def deepcopy(self):
        return State(copy.deepcopy(self.route), copy.deepcopy(self.distance))

    def update_distance(self, dist_matrix, start_point):
        self.distance = 0

        from_index = start_point

        for i in range(len(self.route)):
            self.distance += dist_matrix[from_index][self.route[i]]
            from_index = self.route[i]
            
        self.distance += dist_matrix[from_index][start_point]


def init_population(dist_matrix, start_point, point_indexes, generations):
    gene_pool = point_indexes.copy()

    gene_pool.pop(start_point)

    population = []
    for i in range(generations):
        random.shuffle(gene_pool)

        state = State(gene_pool[:])
        state.update_distance(dist_matrix, start_point)

        population.append(state)

    return population


def crossover(dist_matrix, start_point, parents):
    first_parent = parents[0].deepcopy()
    second_parent = parents[1].deepcopy()

    # the different parts of the child genes
    first_part = []
    second_part = []

    # which genes to get from the parents
    a = int(random.random() * len(first_parent.route))
    b = int(random.random() * len(second_parent.route))
    start_gene = min(a, b)
    end_gene = max(a, b)

    # genes from the first parent
    for i in range(start_gene, end_gene):
        first_part.append(first_parent.route[i])

    # genes from the second parent
    second_part = [int(x) for x in second_parent.route if x not in first_part]

    state = State(first_part + second_part)
    state.update_distance(dist_matrix, start_point)

    return state


def mutate(dist_matrix, start_point, state, mutation_rate):
    mutated_state = state.deepcopy()

    # go though all of the states
    for i in range(len(mutated_state.route)):

        # should we mutate
        if(random.random() < mutation_rate):

            # swap two points
            j = int(random.random() * len(state.route))
            first_city = mutated_state.route[i]
            second_city = mutated_state.route[j]
            mutated_state.route[i] = second_city
            mutated_state.route[j] = first_city

    mutated_state.update_distance(dist_matrix, start_point)
    return mutated_state


def genetic_algorithm(dist_matrix, start_point, steps_to_print_length, population, keep, mutation_rate, generations):
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


def distance_between_two_points(first_point, second_point):
    return int(math.dist(first_point, second_point))


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

    point_indexes = [i for i in range(n)]
    points = [(random.randint(-COORDINATE_SYSTEM_LIMITS, COORDINATE_SYSTEM_LIMITS), 
               random.randint(-COORDINATE_SYSTEM_LIMITS, COORDINATE_SYSTEM_LIMITS)) for _ in range(n)]

    # calculate distances between the points
    dist_matrix = init_distance_matrix(n, points)

    # algorithm parameters
    start = random.randint(0, n - 1)
    generations = 100
    mutation_rate = 0.01
    keep = 10

    between_steps = generations // 4
    steps_to_print_length = [i for i in range(generations, 10, -between_steps)]
    steps_to_print_length.append(10)

    population = init_population(dist_matrix, start, point_indexes, generations)
    final_state = genetic_algorithm(dist_matrix, start, steps_to_print_length, population, keep, mutation_rate, generations)

    print(f'Fittest individual on step {generations}: ', final_state.distance)


if __name__ == "__main__":
    main()
