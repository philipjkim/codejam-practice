#!/usr/bin/env ruby

def do_ls(case_number, lines, out_file)
	credit_line_number = (case_number * 3) - 2
	credit = Integer(lines[credit_line_number])
	prices_line_number = (case_number * 3)
	prices = lines[prices_line_number].split.map{|price| Integer(price)}
	wanted_price1_index = -1
	wanted_price2_index = -1
	current_price1_index = 0

	while wanted_price1_index < 0 and wanted_price2_index <0 do
		(current_price1_index+1).upto(prices.length-1) do |i|
			if prices[current_price1_index] + prices[i] == credit
				wanted_price1_index = current_price1_index + 1
				wanted_price2_index = i + 1
				break
			end
		end
		current_price1_index += 1
	end

	out_file.puts "Case ##{case_number}: #{wanted_price1_index} #{wanted_price2_index}"
	print "."
end

def do_sooo(case_number, lines, out_file)
	credit_line_number = (case_number * 3) - 2
	credit = Integer(lines[credit_line_number])
	prices_line_number = (case_number * 3)
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
		expected_index = temp_index_prices.map{|i, p| p}.index(expected_price)
		if expected_index
			valid_pairs = [index, temp_index_prices[expected_index][0]]
			break
		end
	end

	out_file.puts("Case ##{case_number}: #{valid_pairs.join(' ')}")
	print "."
end

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

	started = Time.now

	out_filename = in_filename.split(".").first + ".out"
	out_file = File.open(out_filename, 'w')

	lines = File.open(in_filename).read.split("\n")
	num_cases = Integer(lines[0])
	1.upto(num_cases) do |case_number|
=begin
		do_ls(case_number, lines, out_file)
=end
		do_sooo(case_number, lines, out_file)

	end
	print "\n#{Time.now - started}\n"
end
