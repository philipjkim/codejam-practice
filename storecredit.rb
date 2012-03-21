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
		prices_line_number = (case_number * 3)
		print "Case No. #{case_number}: ",
			"credit=#{lines[credit_line_number]}, ",
			"prices=#{lines[prices_line_number]}\n"
	end

end
