#!/usr/bin/env ruby

if __FILE__ == $0
	unless ARGV.length == 1
		puts "Usage: #{$0} input_filename"
		exit
	end
	in_filename = ARGV[0]
	unless File.exist?(in_filename)
		puts "File not exist: #{in_filename}"
		exit
	end

	out_filename = in_filename.split(".").first + ".out"
	out_file = File.open(out_filename, 'w')

	lines = File.open(in_filename).read.split("\n")
	num_cases = Integer(lines[0])
	1.upto(num_cases) do |case_number|
		credit_line_number = (case_number * 3) - 2
		credit = Integer(lines[credit_line_number])
		prices_line_number = (case_number * 3)
		prices = lines[prices_line_number].split.map{|price| Integer(price)}

		index_prices = []
		raw_prices = lines[prices_line_number].split
		raw_prices.length.times do |i|
			index_prices.push([i+1, Integer(raw_prices[i])])
		end

		valid_pairs = nil
		index_prices.each do |index, price|
			temp_index_prices = Array.new(index_prices)
			temp_index_prices.delete_at(index -1)
			expected_price = credit - price
			expected_index = temp_index_prices.map{|i, p| p}
								.index(expected_price)
			if expected_index
				valid_pairs = [index, temp_index_prices[expected_index][0]]
				break
			end
		end

		out_file.puts("Case ##{case_number}: #{valid_pairs.join(' ')}")
	end

end
