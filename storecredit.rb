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

	lines = File.open(in_filename).read.split("\n")
	num_cases = Integer(lines[0])
	1.upto(num_cases) do |case_number|
		credit_line_number = (case_number * 3) - 2
		credit = Integer(lines[credit_line_number])
		prices_line_number = (case_number * 3)
		prices = lines[prices_line_number].split.map{|price| Integer(price)}

		valid_pairs = nil
		prices.each do |price|
			expected_price = credit - price
			if prices.include?(expected_price)
				valid_pairs = [prices.index(price)+1,
								prices.index(expected_price)+1]
				break
			end
		end

		puts "Case ##{case_number}: #{valid_pairs.join(' ')}"
	end

end
